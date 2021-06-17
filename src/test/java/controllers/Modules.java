package controllers;

import testModules.AmazonCheckout;
import testModules.GuestUserCheckout;
import testModules.RegisteredUserCheckout;

public class Modules {

	/***
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Function - Return the object of that selected Module class
	 * 
	 * @param ModuleName - Module name
	 * @return - Object of module class * * * * * * * * * * * * * * * * * * * * * *
	 *         * * * * * * * * * * * * * * *
	 */

	public ModuleInterface testModulesSelection(String ModuleName) {
		if (ModuleName.equalsIgnoreCase("AmazonModule"))
			return new AmazonCheckout();
		else if (ModuleName.equalsIgnoreCase("GuestUserCheckoutModule"))
			return new GuestUserCheckout();
		else if (ModuleName.equalsIgnoreCase("RegisteredUserCheckoutModule"))
			return new RegisteredUserCheckout();
		else

			return null;
	}

}
