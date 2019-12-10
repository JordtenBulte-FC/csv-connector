package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(csv.actions.CountLines.class);
    registrator.registerUserAction(csv.actions.ExportCSV.class);
    registrator.registerUserAction(csv.actions.ExportOQLToCSV.class);
    registrator.registerUserAction(csv.actions.ExportSQLToCSV.class);
    registrator.registerUserAction(csv.actions.ImportCSV.class);
    registrator.registerUserAction(csv.actions.ReadNextLine.class);
    registrator.registerUserAction(csv.actions.WriteNextLine.class);
    registrator.registerUserAction(oql.actions.AddBooleanParameter.class);
    registrator.registerUserAction(oql.actions.AddDateTimeParameter.class);
    registrator.registerUserAction(oql.actions.AddDecimalParameter.class);
    registrator.registerUserAction(oql.actions.AddFloatValue.class);
    registrator.registerUserAction(oql.actions.AddIntegerLongValue.class);
    registrator.registerUserAction(oql.actions.AddObjectParameter.class);
    registrator.registerUserAction(oql.actions.AddStringParameter.class);
    registrator.registerUserAction(oql.actions.ExecuteOQLStatement.class);
    registrator.registerUserAction(oql.actions.ExportOQLToCSV.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
