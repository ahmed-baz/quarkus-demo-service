package org.demo.app.service;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.demo.app.mapper.BaseMapper;
import org.demo.app.model.BaseDTO;

import java.util.List;

public interface AppManager<E extends PanacheEntity, D extends BaseDTO> {

    D add(D d);

    D update(Long id, D dto);

    boolean delete(Long id);

    List<D> findAll();

    D findById(Long id);

    BaseMapper<E, D> getMapper();

    PanacheRepository getRepo();

}
