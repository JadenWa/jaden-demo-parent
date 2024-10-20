/*
package com.jaden.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        // 框架方法不要深究，主要是为了返回 CustomUserDetail 
        //NovaUser novaUser = AuthUtil.getUser();
        CustomUserDetail customUser = new CustomUserDetail();
        */
/*customUser.setUserId(novaUser.getUserId());
        customUser.setUsername(novaUser.getUserName());
        customUser.setTenant(novaUser.getTenantId());
        customUser.setPostId(1L);
        customUser.setCompanyId(ObjectUtil.isNotEmpty(novaUser.getCompanyId())?Long.valueOf(novaUser.getCompanyId()):1L);
        customUser.setDeptId(ObjectUtil.isNotEmpty(novaUser.getDeptId())?Long.valueOf(novaUser.getDeptId()):1L);
        customUser.setPostId(ObjectUtil.isNotEmpty(novaUser.getPostId())?Long.valueOf(novaUser.getPostId()):1L);
        customUser.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(novaUser.getRoleName()));*//*

        return customUser;
    }
}
*/
