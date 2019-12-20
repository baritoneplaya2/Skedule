package org.launchcode.Skedule.models.data;

import org.launchcode.Skedule.models.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventsDao extends CrudRepository<Events, Integer> {
//    Events findByStartDate(String startDate);
    Events findById(int eventsId);
}
