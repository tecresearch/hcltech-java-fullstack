/*
 * 🧠 Summary
Option	Meaning	Use When
proxyTargetClass=true	Use CGLIB proxies	Your class doesn’t implement an interface
exposeProxy=true	Expose proxy to self	You need internal method calls to be intercepted
 */

package com.hcl.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = false)
public class AspectProxyConfig {

}
