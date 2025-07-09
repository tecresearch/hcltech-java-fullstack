package com.hcl.tokens.identifiers;
 

public class OutsideClass {
    public void tryAccess() {
        PackageExample obj = new PackageExample();
        // System.out.println(obj.packageVar); // ❌ Error: packageVar not accessible
    }
}
