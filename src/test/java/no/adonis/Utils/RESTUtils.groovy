package no.adonis.Utils

import groovyx.net.http.HTTPBuilder
import net.sf.json.JSON
import no.adonis.Common.Constants
import no.adonis.Timeregistrations.Timeregistration
import no.adonis.Users.Employee
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

import static groovyx.net.http.Method.POST

class RESTUtils {

    static final def HTTPRequest = new HTTPBuilder(Constants.REST_URL)
    static String API_Token
    static DateTimeFormatter dtfOut

    static {
        API_Token = getAPIToken()
        dtfOut = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
    }

    static String getAPIToken() {
        if (API_Token == null) {
            HTTPRequest.request(POST, JSON) { req ->
                uri.path = Constants.CREW_PORTAL_WEB_SERVICE_URI + '/GNL_API_AUTHENTICATION'
                body = ["credentials":
                                [
                                        "Login"   : "Adonis_API",
                                        "Password": "1",
                                        "LifeTime": 3600
                                ]
                ]
                response.success = { resp, json ->
                    println 'request was successful'
                    return json.GNL_API_AUTHENTICATIONResult.Authentication_Token
                }
            }
        } else return API_Token
    }

    static void createTimeRegistration(Employee crewmember, Timeregistration timeregistration) {
        HTTPRequest.request(POST, JSON) { req ->
            uri.path = Constants.CREW_PORTAL_WEB_SERVICE_URI + TAA_AddNewTimeRegistration
            body = [
                    "request": [
                            "Appointment"         : 0,
                            "Period"              : 0,
                            "Timein"              : dtfOut.print(timeregistration.timeIn),
                            "Timeout"             : dtfOut.print(timeregistration.timeOut),
                            "WorkType"            : 520000030,
                            "IsRecursive"         : false,
                            "RepeateDays"         : 1,
                            "Timezone"            : 2,
                            "Pin"                 : 30941,
                            "ApproverPin"         : 30941,
                            "ApproverPosition"    : 100000109,
                            "VesselNumorgId"      : 54,
                            "Authentication_Token": API_Token
                    ]
            ]
        }
    }
}

/*

    public class RestUtils {

        //Need to check
        //Copied from Iaroslav's project

        */
/*
          *//*
/*  {
              "bgTargetLowExtreme": 54.0,
              "bgTargetLow": 70.0,
              "bgTargetHighExtreme": 250.0,
              "bgTargetHigh": 180.0,
              "carbExchangeRatio": 15.0,
              "bgUnits": "MMOL_L",
              "carbUnits": "GRAMS",
              "timeUnits": "TWELVE",
              "syncWithPersonal": false,
              "clinicPreferencesFlag": false
          }*//*
/*

        static HashMap<String, String> getClinicPreferences() {
            Map<String, String> result = [:]
            HTTPRequest.request(POST, JSON) { req ->
                    headers['Cookie'] = getCookie()
                uri.path = 'hcp/clinics/getClinicPreferences'
                response.success = { resp, json ->
                        logResponse("hcp/clinics/getClinicPreferences", json)
                        result = json as HashMap<String, String>
                }

            }
            result
        }
        HTTPBuilder - class for working with REST

        *//*

    }
*/



/*

static String getAPIToken() {
        if (API_Token == null) {
            HTTPRequest.request(POST, JSON) { req ->
                uri.path = '/AdonisWebServices_TestUpgrade/CrewPortalWebService.svc/GNL_API_AUTHENTICATION'
                body = ["credentials":
                                [
                                        "Login"   : "Adonis_API",
                                        "Password": "1",
                                        "LifeTime": 3600
                                ]
                ]
                response.success = { resp, json ->
                    println 'request was successful'
                    println json
                    return json.GNL_API_AUTHENTICATIONResult.Authentication_Token
                }
            }
        } else return API_Token
    }

    static void addNewTimeRegistration() {
        HTTPRequest.request(POST, JSON) { req ->
            uri.path = '/AdonisWebServices_TestUpgrade/CrewPortalWebService.svc/TAA_AddNewTimeRegistration'
            body = [
                    "request": [
                            "Appointment"         : 0,
                            "Period"              : 0,
                            "Timein"              : '2018-06-05 10:00:00',
                            "Timeout"             : '2018-06-05 09:00:00',
                            "WorkType"            : 520000030,
                            "IsRecursive"         : false,
                            "RepeateDays"         : 1,
                            "Timezone"            : 2,
                            "Pin"                 : 30941,
                            "ApproverPin"         : 30941,
                            "ApproverPosition"    : 100000109,
                            "VesselNumorgId"      : 54,
                            "Authentication_Token": API_Token
                    ]
            ]

            println body

            response.success = { resp, json ->
                println 'request was successful'
                println json
            }
        }
    }


*/

