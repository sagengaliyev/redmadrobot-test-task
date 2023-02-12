package kz.robot.testtask.reports;

import kz.robot.testtask.reports.base.AbstractProcedureSuccessReport;

public class ResourceCreationReport extends AbstractProcedureSuccessReport {
    private final Class<?> clazz;
    public ResourceCreationReport(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getMessage() {
        return "Resource successfully created: " + clazz.getSimpleName();
    }
}
