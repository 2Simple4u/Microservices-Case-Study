package com.spring.security.itransformsecurity.model;

import java.util.Optional;

public interface ApplicationUserDao {

	Optional<ApplicationUser> selectApplicationByUsername(String username);
}
