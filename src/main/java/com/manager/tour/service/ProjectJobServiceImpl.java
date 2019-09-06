package com.manager.tour.service;

import com.manager.entry.tour.ProjectJob;
import com.manager.tour.dao.ProjectJobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project Service Impl
 */
@Service
public class ProjectJobServiceImpl implements ProjectJobService {

    @Autowired
    private ProjectJobMapper projectJobMapper;

    @Override
    public List<ProjectJob> selectList() {
        return projectJobMapper.selectList();
    }
}
