package com.scouter.commons;

public class GenericException extends RuntimeException {

    private ERROR_CODE ec;

    public GenericException(ERROR_CODE ec) {
        this.ec = ec;
    }

    public GenericException(String message, ERROR_CODE ec) {
        super(message);
        this.ec = ec;
    }

    public GenericException(String message, Throwable cause, ERROR_CODE ec) {
        super(message, cause);
        this.ec = ec;
    }

    public GenericException(Throwable cause, ERROR_CODE ec) {
        super(cause);
        this.ec = ec;
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ERROR_CODE ec) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.ec = ec;
    }

//    public static GenericException fromErrorCode(ERROR_CODE errorCode) {
//        return new GenericException(errorCode.getMessage(), errorCode);
//    }

    public String getDisplayMessage() {
        return ec.getMessage();
    }

    public int getErrorCode() {
        return ec.getErrorCode();
    }

    public int getHttpStatus() {
        return ec.getHttpStatus();
    }


    public enum ERROR_CODE{

        EC_UNKNOWN(5000, 500, "Unknown error."),
        EC_PROBLEM_ENCRYPT_PASSWORD(5001, 400, "Problem encrypting password"),
        EC_PROBLEM_GETTING_INPUT_STREAM_FROM_ATTACHMENT(5002, 500, "Problem getting input stream from attachment"),
        EC_BAD_STATUS_STRING(5003, 400, "Bad Status string"),

        //1XX Customer & User related
        EC_USER_DOES_NOT_EXIST (100, 404, "The user does not exist"),
        EC_USER_MORE_THEN_ONE_USER_FOUND (101, 500, "More then one user was found with the given username"),
        EC_PROBLEM_USER_EXIST(102, 409, "Username is already exist. Please enter another username."),
        EC_PASSWORD_IS_MANDATORY(103, 400, "Password is mandatory field when adding new user"),
        EC_PROBLEM_SAVING_USER(105, 500, "Problem occurred while saving user"),
        EC_NO_CUSTOMER_FOUND(107, 400, "Customer not found"),
        EC_PROBLEM_SET_USER_MODE(109, 500, "Problem set user mode."),
        EC_PROBLEM_SAVING_CUSTOMER_LOGO (110, 500, "Problem saving customer logo."),
        EC_PROBLEM_CHANGE_CUSTOMER_STATUS(111, 403, "Problem change customer status."),
        EC_PROBLEM_REMOVE_CUSTOMER_LOGO (112, 500, "Problem remove customer logo."),
        EC_USERNAME_IS_MANDATORY(113, 400, "Username is mandatory field when adding new user"),
        EC_ROLE_IS_MANDATORY(114, 400, "Role is mandatory field."),
        EC_DISPLAY_NAME_IS_MANDATORY(115, 400, "Display name is mandatory field."),
        EC_PROBLEM_GETTING_USER(117, 500, "Problem getting users."),
        EC_USER_ROLE_ISNT_AS_EXPECTED(118, 500, "User role is not as expected"),
        EC_BAD_FILTER_DEFINITION(119, 400, "Bad filter definition: sortBy="),
        EC_PROBLEM_REMOVE_USER (120, 500, "Unauthorized action. Could not remove user."),
        EC_PROBLEM_ADD_USER (121, 500, "Unauthorized action. Could not add user."),
        EC_PROBLEM_UPDATE_USER (122, 500, "Unauthorized action. Could not update user."),
        EC_CUSTOMER_NAME_IS_MANDATORY(123, 400, "Customer Name is mandatory field"),
        EC_CUSTOMER_STORE_DATE_FOR_AT_LEAST_A_MONTH(124, 400, "Customer monthsToStoreData Field mast be greater than zero"),
        EC_CUSTOMER_DOES_NOT_EXIST (125, 404, "The customer does not exist"),
        EC_PROBLEM_SAVING_CUSTOMER(126, 500, "Problem occurred while saving customer"),
        EC_PROBLEM_UPDATING_CUSTOMER(127, 500, "Failed updating Customer."),
        EC_PROBLEM_ADDING_ENTITY_ALREADY_EXIST(128, 500, "Failed adding entity. It already exist."),


        //2XX incident related
        EC_INCIDENT_DOES_NOT_EXIST (200, 404, "The incident does not exist"),


        //3XX PUSH related (GCM)
        EC_DEVICE_TOKEN_NULL_OR_EMPTY(300, 400, "endunit token is null or empty, problem register to push."),


        //4xx unit related
        EC_UNIT_DOES_NOT_EXIST (400, 400, "The unit does not exist"),
        EC_PROBLEM_GETTING_UNITS_TYPE_INFO (401, 400, "Problem getting units type info"),
        EC_UNIT_IS_NOT_AVAILABLE (403, 409, "The unit is not available"),
        EC_UNIT_COMMUNICATION_EXCEPTION (405, 400, "End Unit Communication failure"),

        EC_PROBLEM_GETTING_UNIT_INCIDENT_HISTORY(410, 500, "Problem getting unit incident history"),
        EC_THERE_IS_NO_UNIT_INCIDENT_HISTORY(411, 500, "There is no unit incident history."),
        EC_UNIT_ALREADY_ACCEPT_THE_INCIDENT_ASSIGNMENT(412, 409, "Unit already accepted the incident assignment - can't decline the assignemnt"),
        EC_UNABLE_TO_SET_UNIT_STATUS(413, 500, "Unable to set new Status to unit"),
        EC_PROBLEM_GETTING_UNITS(414, 500, "Problem getting units."),

        EC_PROBLEM_ADD_UNIT(419, 500, "Problem occurred while adding unit"),

        EC_PROBLEM_UPDATE_SOP_SIMPLE_TASK(414, 500, "Problem update Sop simple task status"),


        //7xx
        EC_PROBLEM_GETTING_INCIDENT_TYPES(700, 500, "Problem getting incident type definitions."),
        EC_PROBLEM_GETTING_UNITS_OF_AGENCY(701, 500, "Problem getting units of agencies."),

        //8xx GENERAL ENTITY
        EC_ILLEGAL_ATTEMPT_TO_DELETE_ENTITY_OF_OTHER_CUSTOMER(801, 500, "Illegal attempt to delete entity of other Customer."),


        EC_PROBLEM_SAVING_MESSAGE(501, 500, "Problem saving message"),
        EC_AGENCY_DOES_NOT_EXIST(600, 404, "Agency does not exist."),
        EC_FAILED_ADDING_END_UNIT(900, 404, "Camera does not exist"),
        EC_FAILED_UPDATING_END_UNIT(901, 500, "Failed updating End Unit."),
        EC_FAILED_UPDATING_CLIENT(901, 500, "Failed updating Client."),
        EC_FAILED_UPDATING_MESSAGES(901, 500, "Failed updating Messages."),
        EC_FAILED_UPDATING_DISTRIBUTION_LIST(901, 500, "Failed updating Distribution List."),

        //12xx Customer related
        EC_USER_MORE_THEN_ONE_CUSTOMER_FOUND (1201, 500, "More then one customer was found with the given name"),


        //13xx Channel related
        EC_PROBLEM_GETTING_CHANNELS(1314, 500, "Problem getting channels."),
        EC_CHANNEL_DOESNT_EXIST(1315, 500, "Channel does not exist."),
        EC_PROBLEM_GETTING_CHANNEL_DATA(1316, 500, "Problem getting channel data."),

        // 14xx Monitor related
        EC_PROBLEM_ADD_MONITOR(1400, 500, "Problem occurred while adding a Monitor."),
        EC_PROBLEM_GETTING_MONITORS_LIST(1402, 500, "Problem occurred while getting list of Monitors."),
        EC_PROBLEM_GETTING_MONITORS_DATA_FOR_REPORT(1403, 500, "Problem occurred while getting list of Monitors data for report."),
        EC_PROBLEM_GETTING_MONITOR_CHANNEL_LIST(1404, 500, "Problem occurred while getting list of Monitor Channels."),
        EC_NO_MONITOR_TYPE_FOUND(1406, 500, "Failed to find a Monitor Type."),
        EC_PROBLEM_SAVING_MONITOR_TYPE_ICON(1408, 500, "Failed to save Monitor Type icon."),
        EC_FAILED_TO_RETRIEVE_MONITOR_TYPE_LIST(1410, 500, "Failed to retrieve Monitor Type List."),
        EC_FAIL_TO_GET_MONITOR_CHANNEL_BY_ID(1412, 500, "Failed to retrieve Monitor Channel by id"),
        EC_FAIL_ADDING_MONITOR_CHANNEL(1414, 500, "Failed to add new Monitor Channel."),
        EC_MONITOR_CHANNEL_DOES_NOT_EXIST(1416, 500, "Monitor Channel not found."),
        EC_FAILED_UPDATE_MONITOR_CHANNEL(1418, 500, "Failed to update Monitor Channel."),
        EC_FAILED_TO_RETRIEVE_SIMPLE_MONITOR_CHANNEL_DATA(1420, 500, "Failed to retrieve Simple Monitor Channel Data."),
        EC_COULD_NOT_FIND_MONITOR(1422, 500, "Failed to find Monitor."),
        EC_COULD_NOT_UPDATE_MONITOR(1424, 500, "Failed to update Monitor."),
        EC_PROBLEM_GETTING_MONITOR_BY_ID(1426, 500, "Failed to retrieve Monitor by id."),
        EC_PROBLEM_GETTING_MONITOR_TYPE_ICON(1428, 500, "Failed to get Monitor Type Icon."),
        EC_ADD_MONITOR_FAILURE(1429, 500, "Failure addig Monitor."),
        EC_COULD_NOT_MONITOR_TYPE(1430, 500, "Failed to find Monitor Type."),
        EC_COULD_NOT_FIND_PROPERTY(1431, 500, "Failed to find Property."),
        EC_FAILED_TO_REMOVE_MONITOR(1432, 500, "Failed to remove Monitor."),
        EC_UNAUTHORIZED_ACCESS_TO_RESOURCE(1433, 500, "Unauthorized access to resource."),
        EC_PROBLEM_EXPORT_MONITORS_TO_CSV(1434, 500, "Failed export Monitors toi CSV."),

        //15xx Audit related
        EC_PROBLEM_GETTING_AUDIT_LIST(1500, 500, "Problem getting Audit list"),

        // 16XX Property related
        EC_PROBLEM_ADDING_PROPERTY(1600, 500, "Problem adding a Property."),
        EC_PROBLEM_GETTING_PROPERTY_LIST(1601, 500, "Problem getting Property List."),
        EC_PROBLEM_GETTING_ALL_PROPERTY_LIST(1601, 500, "Problem getting all Property List."),
        EC_PROBLEM_PROPERTY_NOT_FOUND(1602, 500, "Failed to find Property."),
        EC_PROBLEM_PROPERTY_VALUE_NOT_FOUND(1602, 500, "Failed to find Property's value."),
        EC_FAILED_REMOVING_PROPERTY(1603, 500, "Error removing Property."),
        EC_ERROR_UPDATE_PROPERTY(1604, 500, "Error updating Property."),
        EC_PROBLEM_GETTING_VALUE_LIST_OF_PROPERTY(1605, 500, "Error occurred while getting Property Value List"),

        // 17xx Alert related
        EC_FAILED_ADDING_ALERT(1700, 500, "Failed to add alert."),
        EC_FAILED_GETTING_ALERT(1702, 500, "Failed to get alert."),
        EC_FAILED_REMOVING_ALERT(1704, 500, "Failed to remove alert."),
        EC_FAILED_UPDATE_ALERT(1706, 500, "Failed to update alert."),

        // 18xx MTX Communicator related
        EC_MTX_COMMUNICATION_WRAPPER_PROBLEM(1800, 500, "Generic MTX Communication Wrapper problem."),
        EC_MTX_COMMUNICATION_WRAPPER_CONNECTION_REFUSED(1801, 500, "MTX Communication failure - connection refused."),
        EC_MTX_COMMUNICATION_WRAPPER_LOGIN_FAILURE(1802, 500, "MTX Communication failure - login failure."),
        EC_MTX_COMMUNICATION_WRAPPER_CMD_TIMEOUT(1803, 500, "MTX Communication failure - command timeout."),
        EC_MTX_COMMUNICATION_WRAPPER_CONNECTION_TIMEOUT(1804, 500, "MTX Communication failure - connection timeout."),
        EC_MTX_COMMUNICATION_WRAPPER_PARAM_UPDATE_FAILURE(1805, 500, "MTX Communication parameter update failed"),

        // 19xx MTX Command Logic
        EC_MTX_COMMAND_LOGIC(1900, 500, "Generic MTX Command Logic problem."),
        EC_MTX_COMMAND_LOGIC_EMPTY_PARAM_MAP(1901, 500, "MTX Parameters Map is null or empty.");


        private int code;
        private String message;
        private int httpStatus;

        private ERROR_CODE(int code, int httpStatus, String message) {
            this.code = code;
            this.message = message;
            this.httpStatus = httpStatus;
        }

        public int getErrorCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public int getHttpStatus() {return httpStatus; }
    }
}