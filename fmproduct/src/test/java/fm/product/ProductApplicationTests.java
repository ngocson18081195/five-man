package fm.product;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fm.product.dto.ProductDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ProductApplicationTests {

    @Test
    public void Import() throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clz = ProductDTO.class;
        FileInputStream fileInputStream = new FileInputStream(
                new File("/home/ngocson/employee.xls"));
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        this.convertObject(sheet, clz);




    }

    private void convertObject(Sheet sheet, Class<?> clz) throws IllegalAccessException, InstantiationException {
        Map<String, Method> methodMap = this.getAllMethod(clz);
        List<String> stringList = this.getField(sheet);


        List<Object> objects = Lists.newLinkedList();
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Object o = clz.newInstance();
            Row row = rowIterator.next();
            if (row.getRowNum() >= 5) {
                int count = 0;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (Objects.isNull(cell)) {
                        break;
                    }
                    Method method = methodMap.get(stringList.get(count));
                    try {
                        method.invoke(o, cell.getStringCellValue());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
                objects.add(o);
            }
        }
    }

    private List<String> getField(Sheet sheet) {
        Row thirdRow = sheet.getRow(3);
        List<String> stringList = Lists.newLinkedList();
        if (Objects.nonNull(thirdRow)) {
            Iterator<Cell> cellIterator = thirdRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                stringList.add(cell.getStringCellValue());
            }
        }
        return stringList;
    }

    private Map<String, Method> getAllMethod(Class<?> clz) {
        Method[] declaredMethods = clz.getMethods();
        Map<String, Method> methodMap = Maps.newHashMap();
        for (Method method: declaredMethods) {
            if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                String substring = method.getName().substring(3, method.getName().length());
                String uncapitalize = StringUtils.uncapitalize(substring);
                methodMap.put(uncapitalize, method);
            }
        }
        return methodMap;
    }

}
