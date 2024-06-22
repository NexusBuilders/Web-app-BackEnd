package com.example.EasyFood.iam.infraestructure.hashing.bcrypt;

import com.example.EasyFood.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}

