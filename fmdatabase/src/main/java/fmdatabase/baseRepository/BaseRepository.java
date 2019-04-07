package fmdatabase.baseRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Create by ngocson on 06/04/2019
 */
@NoRepositoryBean
public interface BaseRepository<E, ID extends Serializable> extends CrudRepository<E, ID> {
}
