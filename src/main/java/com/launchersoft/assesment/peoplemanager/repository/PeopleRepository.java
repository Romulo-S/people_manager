package com.launchersoft.assesment.peoplemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.launchersoft.assesment.peoplemanager.model.People;

public interface PeopleRepository extends JpaRepository<People,Long> {
}
