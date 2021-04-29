package org.clp.xslt.demo.dest.oop;

import org.springframework.data.repository.CrudRepository;
public interface PushDataRepository extends CrudRepository<PushData, Integer> {
	PushData findByOname(String name);
}
