package service;

import domain.SysLog;

import java.util.List;

public interface SysLogService {

    void save(SysLog sysLog);
    List<SysLog> findAll();
}
