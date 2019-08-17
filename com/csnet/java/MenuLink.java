package com.csnet.java;

public enum MenuLink {
	HOME("Home"),
	LOGINHELP("Login Help?"),
	REGISTER("Register"),
	KNOWLEDGEBASE("Knowledge Base"),
	NEWTR("Open New TR"),
	CSBS("CSBs"),
	DOWNLOADS("Downloads"),
	USERPROFILE("UserProfile"),
	ENVADMIN("Env Admin"),
	CSBADMIN("CSB Admin"),
	KNADMIN("KB Admin"),
	SYSADMIN("SystemAdmin"),
	ACCOUNTADMIN("Account Admin"),
	USERADMIN("User Admin"),
	RELEASEADMIN("Release Admin"),
	SOLUTIONADMIN("Solution Admin"),
	PATCHADMIN("Patch Admin"),
	BDNUMADMIN("BD Num Admin");
	
    public final String linkText;
    
    private MenuLink(String linkText) {
        this.linkText = linkText;
    }

}
