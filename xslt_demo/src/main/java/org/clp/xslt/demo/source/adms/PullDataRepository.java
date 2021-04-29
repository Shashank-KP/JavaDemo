package org.clp.xslt.demo.source.adms;

import org.springframework.data.repository.CrudRepository;
public interface PullDataRepository extends CrudRepository<PullData, Integer> {
	PullData findByName(String name);
}