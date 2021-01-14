package com.rui.ass.service;

import com.rui.ass.dao.ActivityDao;
import com.rui.ass.dao.AssDao;
import com.rui.ass.entity.Activity;
import com.rui.ass.entity.Ass;
import com.rui.framework.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ActivityService extends BaseService<ActivityDao, Activity> {

}
