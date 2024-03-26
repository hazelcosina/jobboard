package com.ota.jobboard.service.impl;

import com.ota.jobboard.entity.Position;

public class NotificationFactory {

    public static String buildNotificationContent(Position position) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("<!DOCTYPE html>\n");
        contentBuilder.append("<html lang=\"en\">\n");
        contentBuilder.append("<head>\n");
        contentBuilder.append("    <meta charset=\"UTF-8\">\n");
        contentBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        contentBuilder.append("    <title>New Job Posting</title>\n");
        contentBuilder.append("    <style>\n");
        contentBuilder.append("        body {\n");
        contentBuilder.append("            font-family: Arial, sans-serif;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .container {\n");
        contentBuilder.append("            max-width: 600px;\n");
        contentBuilder.append("            margin: 0 auto;\n");
        contentBuilder.append("            padding: 20px;\n");
        contentBuilder.append("            border: 1px solid #ddd;\n");
        contentBuilder.append("            border-radius: 10px;\n");
        contentBuilder.append("            background-color: #f9f9f9;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        h2 {\n");
        contentBuilder.append("            color: #333;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .job-details {\n");
        contentBuilder.append("            margin-top: 20px;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .job-details p {\n");
        contentBuilder.append("            margin: 5px 0;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .button {\n");
        contentBuilder.append("            display: inline-block;\n");
        contentBuilder.append("            padding: 10px 20px;\n");
        contentBuilder.append("            text-align: center;\n");
        contentBuilder.append("            text-decoration: none;\n");
        contentBuilder.append("            border: none;\n");
        contentBuilder.append("            border-radius: 5px;\n");
        contentBuilder.append("            cursor: pointer;\n");
        contentBuilder.append("            width: 150px;\n");
        contentBuilder.append("            font-weight: bold;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .button-approve {\n");
        contentBuilder.append("            background-color: #4CAF50; /* Green */\n");
        contentBuilder.append("            color: black;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .button-spam {\n");
        contentBuilder.append("            background-color: #ffcc00; /* Yellow */\n");
        contentBuilder.append("            color: black;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("        .button:hover {\n");
        contentBuilder.append("            opacity: 0.8;\n");
        contentBuilder.append("        }\n");
        contentBuilder.append("    </style>\n");
        contentBuilder.append("</head>\n");
        contentBuilder.append("<body>\n");
        contentBuilder.append("    <div class=\"container\">\n");
        contentBuilder.append("        <h2>New Job Posting</h2>\n");
        contentBuilder.append("        <div class=\"job-details\">\n");
        contentBuilder.append("            <p><strong>Position Name:</strong> ").append(position.getName()).append("</p>\n");
        contentBuilder.append("            <p><strong>Company:</strong> ").append(position.getCompany()).append("</p>\n");
        contentBuilder.append("            <p><strong>Job Description:</strong> ").append(position.getDescription()).append("</p>\n");
        contentBuilder.append("        </div>\n");
        contentBuilder.append("        <a href=\"http://localhost:8080/positions/status?positionId="+position.getId()+"&status=APPROVED\" style=\"display: inline-block; padding: 10px 20px; text-align: center; text-decoration: none; background-color: #4CAF50; color: black; border: none; border-radius: 5px; cursor: pointer;\">Approve</a>\n");
        contentBuilder.append("        <a href=\"http://localhost:8080/positions/status?positionId="+position.getId()+"&status=REJECTED\" style=\"display: inline-block; padding: 10px 20px; text-align: center; text-decoration: none; background-color: #FF5733; color: black; border: none; border-radius: 5px; cursor: pointer;\">Reject</a>\n");
        contentBuilder.append("    </div>\n");
        contentBuilder.append("<script>\n");
        contentBuilder.append("</body>\n");
        contentBuilder.append("</html>");


        return contentBuilder.toString();
    }
}
