package org.egmaza.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio, CrudRepositorio<T>{

}
