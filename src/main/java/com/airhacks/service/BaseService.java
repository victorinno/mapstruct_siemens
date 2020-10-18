package com.airhacks.service;

import com.airhacks.dto.BaseDto;
import com.airhacks.entity.BaseEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseService<T extends BaseEntity, DTO extends BaseDto, ID, MAPPER> {

    @Inject
    protected MAPPER mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public DTO persist(DTO o) {
        final T entity = convertToEntity(o);
        entityManager.merge(entity);
        return convertToDto(entity);
    }

    public DTO merge(DTO o) {
        T entity = entityManager.find(inferClass(), o.getId());
        updateEntity(o, entity);
        entity = entityManager.merge(convertToEntity(o));
        return convertToDto(entity);
    }

    public void remove(ID id) {
        final T entity = entityManager.find(inferClass(), id);
        entityManager.remove(entity);
    }

    public DTO findById(ID id) {
        return convertToDto(entityManager.find(inferClass(), id));
    }

    public List<DTO> findByAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(inferClass());
        Root<T> c = q.from(inferClass());
        q.select(c);
        TypedQuery<T> query = entityManager.createQuery(q);
        return convertToDto(query.getResultList());
    }

    protected abstract Class<T> inferClass();

    protected abstract DTO convertToDto(T entity);

    protected abstract T convertToEntity(DTO dto);

    protected abstract List<DTO> convertToDto(List<T> entity);

    protected abstract List<T> convertToEntity(List<DTO> dto);

    protected abstract void updateEntity(DTO dto, T entity);



}
