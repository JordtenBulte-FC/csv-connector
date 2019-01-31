// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oql.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import oql.implementation.OQL;

public class AddIntegerLongValue extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String name;
	private java.lang.Long value;

	public AddIntegerLongValue(IContext context, java.lang.String name, java.lang.Long value)
	{
		super(context);
		this.name = name;
		this.value = value;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		OQL.addParameter(name, value);
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "AddIntegerLongValue";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
