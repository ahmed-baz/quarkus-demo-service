package org.demo.app.service.impl;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import org.demo.app.model.BaseDTO;
import org.demo.app.service.AppManager;

import java.util.List;

@Setter
@Getter
public abstract class AppManagerImpl<E extends PanacheEntity, D extends BaseDTO> implements AppManager<E, D> {

    @Override
    public D add(D dto) {
        doValidateBeforeMapping(dto);
        E entity = getMapper().dtoToEntity(dto);
        doValidateEntityBeforeCreate(dto, entity);
        doPrepareEntity(dto, entity);
        getRepo().persist(entity);
        doAfterCreate(dto, entity);
        return getMapper().entityToDto(entity);
    }


    @Override
    public D update(Long id, D dto) {
        E entity = loadById(id);
        doValidateBeforeMapping(dto);
        getMapper().updateEntityFromDto(dto, entity);
        doBeforeUpdate(dto, entity);
        doValidateEntityBeforeUpdate(dto, entity);
        E savedEntity = doUpdate(entity);
        doAfterUpdate(dto, entity);
        return getMapper().entityToDto(savedEntity);
    }

    private E doUpdate(E entity) {
        getRepo().persist(entity);
        return entity;
    }

    @Override
    public boolean delete(Long id) {
        E e = loadById(id);
        if (null != e) {
            doBeforeDelete(id);
            getRepo().deleteById(id);
            doAfterDelete(id);
        }
        return true;
    }

    @Override
    public List<D> findAll() {
        List<E> all = getRepo().findAll().list();
        return getMapper().entityListToDtoList(all);
    }

    @Override
    public D findById(Long id) {
        E e = loadById(id);
        return getMapper().entityToDto(e);
    }

    private E loadById(Long id) {
        return (E) getRepo().findById(id);
    }

    protected void doValidateBeforeMapping(D dto) {
    }

    protected void doValidateEntityBeforeCreate(D dto, E entity) {
    }

    protected void doValidateEntityBeforeUpdate(D dto, E entity) {
    }

    protected void doPrepareEntity(D dto, E entity) {
    }

    protected void doAfterCreate(D dto, E entity) {
    }

    protected void doBeforeUpdate(D dto, E entity) {
    }

    protected void doAfterUpdate(D dto, E entity) {
    }

    protected void doBeforeDelete(Long id) {
    }

    protected void doAfterDelete(Long id) {
    }
}
