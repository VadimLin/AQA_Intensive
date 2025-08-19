package eu.senla.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;


public class SuiteXmlTransformer implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        String threadCount = System.getProperty("thread-count", "1");
        String parallel = System.getProperty("parallel", "classes");

        for (XmlSuite suite : suites) {
            suite.setThreadCount(Integer.parseInt(threadCount));
            suite.setParallel(XmlSuite.ParallelMode.getValidParallel(parallel));
        }
    }

}
