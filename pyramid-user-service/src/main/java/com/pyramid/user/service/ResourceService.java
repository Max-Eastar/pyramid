package com.pyramid.user.service;

import com.pyramid.user.domain.entity.Resource;
import com.pyramid.user.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public boolean add(Resource resource) {
        boolean result = false;
        if (resource == null) {
            return result;
        }
        resource.setIsEnable((byte) 1);
        return resourceMapper.insert(resource) > 0;
    }

    public boolean update(Resource resource) {
        boolean result = false;
        if (resource == null) {
            return result;
        }
        return resourceMapper.updateByPrimaryKeySelective(resource) > 0;
    }

    public boolean disable(String resourceId) {
        boolean result = false;
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null) {
            return result;
        }
        resource.setIsEnable((byte) 0);
        return resourceMapper.updateByPrimaryKeySelective(resource) > 0;
    }

    public boolean enable(String resourceId) {
        boolean result = false;
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null) {
            return result;
        }
        resource.setIsEnable((byte) 1);
        return resourceMapper.updateByPrimaryKeySelective(resource) > 0;
    }

    public List<Resource> getList() {
        List<Resource> resources = resourceMapper.selectList(null);
        return resources;
    }

    public List<Resource> getEnableList() {
        List<Resource> resources = resourceMapper.selectList((byte) 1);
        return resources;
    }

    public Map<String, String> getFilterDefinitions() {
        List<Resource> resources = getEnableList();
        Map<String, String> filterDefinitions = new HashMap<>();
        if (resources == null || resources.isEmpty()) {
            return filterDefinitions;
        }
        for (Resource resource : resources) {
            if (StringUtils.isEmpty(resource.getFilterAntPath()) || StringUtils.isEmpty(resource.getFilterDefinition())) {
                continue;
            }
            if (!filterDefinitions.containsKey(resource.getFilterAntPath())) {
                filterDefinitions.put(resource.getFilterAntPath(), resource.getFilterDefinition());
            }
        }
        return filterDefinitions;
    }
}
