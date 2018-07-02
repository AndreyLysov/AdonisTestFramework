package no.adonis.Common;

import no.adonis.Utils.SQLUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Constants {
    public static final String BASE_URL = "http://192.168.1.202/app_AdonisAutoTest";
    public static final String REST_URL = "http://192.168.1.202";
    public static final String CREW_PORTAL_WEB_SERVICE_URI = "/AdonisWebServices_TestUpgrade/CrewPortalWebService.svc";
    public static final String CONNECTION_STRING = "jdbc:sqlserver://192.168.1.202;instanceName=SQL2016DEV;databaseName=AdonisAutoTest;user=sa;password=SUPER";
    public static final DateTimeFormatter DTF = DateTimeFormat.forPattern(SQLUtils.getDateTimeFormat());
    public static final DateTimeFormatter TF = DateTimeFormat.forPattern(SQLUtils.getTimeFormat());
    public static final DateTimeFormatter DF = DateTimeFormat.forPattern(SQLUtils.getDateFormat());
}
