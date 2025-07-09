package com.hcl.tokens.identifiers;

public class AnotherClass {
    private static final String value = null;

	public void accessPackageVar() {
        PackageExample obj = new PackageExample();
        System.out.println("Package variable: " + obj.packageVar); // ✅ Accessible
      
       
    }
}
