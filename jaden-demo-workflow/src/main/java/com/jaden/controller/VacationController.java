package com.jaden.controller;

import com.jaden.entity.VacTask;
import com.jaden.entity.Vacation;
import com.jaden.service.VacationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Created by yawn on 2018-01-08 13:42
 */
@RestController
public class VacationController {

    @Resource
    private VacationService vacationService;

    @PostMapping("/startVac")
    public Object startVac(@RequestBody Vacation vac, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if(StringUtils.isNotBlank(userName)){
            return vacationService.startVac(userName, vac);
        }else {
            return null;
        }
    }

    @GetMapping("/myVac")
    public Object myVac(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return vacationService.myVac(userName);
    }

    @GetMapping("/myAudit")
    public Object myAudit(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return vacationService.myAudit(userName);
    }

    @PostMapping("/passAudit")
    public Object passAudit(HttpSession session, @RequestBody VacTask vacTask) {
        String userName = (String) session.getAttribute("userName");
        return vacationService.passAudit(userName, vacTask);
    }

    @GetMapping("/myVacRecord")
    public Object myVacRecord(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return vacationService.myVacRecord(userName);
    }

    @GetMapping("/myAuditRecord")
    public Object myAuditRecord(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return vacationService.myAuditRecord(userName);
    }

}
