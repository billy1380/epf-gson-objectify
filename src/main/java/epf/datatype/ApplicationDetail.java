//  
//  ApplicationDetail.java
//  epf-gson-objectify
//
//  Created by William Shakour on February 12, 2016.
//  Copyright © 2016 WillShex Limited. All rights reserved.
//
package epf.datatype;

import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.AlsoLoad;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.willshex.gson.shared.Jsonable;

@Cache
@Entity(name = "epf_application_detail")
public class ApplicationDetail extends Jsonable {
	@Id public String name;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("application_id") @Index public Key<Application> applicationKey;
	@Ignore public Application application;
	@AlsoLoad("language_code") @Index public String languageCode;
	@AlsoLoad("title") public String title;
	@AlsoLoad("description") public String description;
	@AlsoLoad("release_notes") public String releaseNotes;
	@AlsoLoad("company_url") public String companyUrl;
	@AlsoLoad("support_url") public String supportUrl;
	@AlsoLoad("screenshot_url_1") public String screenshotUrl1;
	@AlsoLoad("screenshot_url_2") public String screenshotUrl2;
	@AlsoLoad("screenshot_url_3") public String screenshotUrl3;
	@AlsoLoad("screenshot_url_4") public String screenshotUrl4;
	@AlsoLoad("screenshot_width_height_1") public String screenshotWidthHeight1;
	@AlsoLoad("screenshot_width_height_2") public String screenshotWidthHeight2;
	@AlsoLoad("screenshot_width_height_3") public String screenshotWidthHeight3;
	@AlsoLoad("screenshot_width_height_4") public String screenshotWidthHeight4;
	@AlsoLoad("ipad_screenshot_url_1") public String ipadScreenshotUrl1;
	@AlsoLoad("ipad_screenshot_url_2") public String ipadScreenshotUrl2;
	@AlsoLoad("ipad_screenshot_url_3") public String ipadScreenshotUrl3;
	@AlsoLoad("ipad_screenshot_url_4") public String ipadScreenshotUrl4;
	@AlsoLoad("ipad_screenshot_width_height_1") public String ipadScreenshotWidthHeight1;
	@AlsoLoad("ipad_screenshot_width_height_2") public String ipadScreenshotWidthHeight2;
	@AlsoLoad("ipad_screenshot_width_height_3") public String ipadScreenshotWidthHeight3;
	@AlsoLoad("ipad_screenshot_width_height_4") public String ipadScreenshotWidthHeight4;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonApplication = application == null ? JsonNull.INSTANCE
				: application.toJson();
		object.add("application", jsonApplication);
		JsonElement jsonLanguageCode = languageCode == null ? JsonNull.INSTANCE
				: new JsonPrimitive(languageCode);
		object.add("languageCode", jsonLanguageCode);
		JsonElement jsonTitle = title == null ? JsonNull.INSTANCE
				: new JsonPrimitive(title);
		object.add("title", jsonTitle);
		JsonElement jsonDescription = description == null ? JsonNull.INSTANCE
				: new JsonPrimitive(description);
		object.add("description", jsonDescription);
		JsonElement jsonReleaseNotes = releaseNotes == null ? JsonNull.INSTANCE
				: new JsonPrimitive(releaseNotes);
		object.add("releaseNotes", jsonReleaseNotes);
		JsonElement jsonCompanyUrl = companyUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(companyUrl);
		object.add("companyUrl", jsonCompanyUrl);
		JsonElement jsonSupportUrl = supportUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(supportUrl);
		object.add("supportUrl", jsonSupportUrl);
		JsonElement jsonScreenshotUrl1 = screenshotUrl1 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotUrl1);
		object.add("screenshotUrl1", jsonScreenshotUrl1);
		JsonElement jsonScreenshotUrl2 = screenshotUrl2 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotUrl2);
		object.add("screenshotUrl2", jsonScreenshotUrl2);
		JsonElement jsonScreenshotUrl3 = screenshotUrl3 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotUrl3);
		object.add("screenshotUrl3", jsonScreenshotUrl3);
		JsonElement jsonScreenshotUrl4 = screenshotUrl4 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotUrl4);
		object.add("screenshotUrl4", jsonScreenshotUrl4);
		JsonElement jsonScreenshotWidthHeight1 = screenshotWidthHeight1 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotWidthHeight1);
		object.add("screenshotWidthHeight1", jsonScreenshotWidthHeight1);
		JsonElement jsonScreenshotWidthHeight2 = screenshotWidthHeight2 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotWidthHeight2);
		object.add("screenshotWidthHeight2", jsonScreenshotWidthHeight2);
		JsonElement jsonScreenshotWidthHeight3 = screenshotWidthHeight3 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotWidthHeight3);
		object.add("screenshotWidthHeight3", jsonScreenshotWidthHeight3);
		JsonElement jsonScreenshotWidthHeight4 = screenshotWidthHeight4 == null
				? JsonNull.INSTANCE : new JsonPrimitive(screenshotWidthHeight4);
		object.add("screenshotWidthHeight4", jsonScreenshotWidthHeight4);
		JsonElement jsonIpadScreenshotUrl1 = ipadScreenshotUrl1 == null
				? JsonNull.INSTANCE : new JsonPrimitive(ipadScreenshotUrl1);
		object.add("ipadScreenshotUrl1", jsonIpadScreenshotUrl1);
		JsonElement jsonIpadScreenshotUrl2 = ipadScreenshotUrl2 == null
				? JsonNull.INSTANCE : new JsonPrimitive(ipadScreenshotUrl2);
		object.add("ipadScreenshotUrl2", jsonIpadScreenshotUrl2);
		JsonElement jsonIpadScreenshotUrl3 = ipadScreenshotUrl3 == null
				? JsonNull.INSTANCE : new JsonPrimitive(ipadScreenshotUrl3);
		object.add("ipadScreenshotUrl3", jsonIpadScreenshotUrl3);
		JsonElement jsonIpadScreenshotUrl4 = ipadScreenshotUrl4 == null
				? JsonNull.INSTANCE : new JsonPrimitive(ipadScreenshotUrl4);
		object.add("ipadScreenshotUrl4", jsonIpadScreenshotUrl4);
		JsonElement jsonIpadScreenshotWidthHeight1 = ipadScreenshotWidthHeight1 == null
				? JsonNull.INSTANCE
				: new JsonPrimitive(ipadScreenshotWidthHeight1);
		object.add("ipadScreenshotWidthHeight1",
				jsonIpadScreenshotWidthHeight1);
		JsonElement jsonIpadScreenshotWidthHeight2 = ipadScreenshotWidthHeight2 == null
				? JsonNull.INSTANCE
				: new JsonPrimitive(ipadScreenshotWidthHeight2);
		object.add("ipadScreenshotWidthHeight2",
				jsonIpadScreenshotWidthHeight2);
		JsonElement jsonIpadScreenshotWidthHeight3 = ipadScreenshotWidthHeight3 == null
				? JsonNull.INSTANCE
				: new JsonPrimitive(ipadScreenshotWidthHeight3);
		object.add("ipadScreenshotWidthHeight3",
				jsonIpadScreenshotWidthHeight3);
		JsonElement jsonIpadScreenshotWidthHeight4 = ipadScreenshotWidthHeight4 == null
				? JsonNull.INSTANCE
				: new JsonPrimitive(ipadScreenshotWidthHeight4);
		object.add("ipadScreenshotWidthHeight4",
				jsonIpadScreenshotWidthHeight4);
		return object;
	}

	@Override
	public void fromJson (JsonObject jsonObject) {
		super.fromJson(jsonObject);
		if (jsonObject.has("exportDate")) {
			JsonElement jsonExportDate = jsonObject.get("exportDate");
			if (jsonExportDate != null) {
				exportDate = new Date(jsonExportDate.getAsLong());
			}
		}
		if (jsonObject.has("application")) {
			JsonElement jsonApplication = jsonObject.get("application");
			if (jsonApplication != null) {
				application = new Application();
				application.fromJson(jsonApplication.getAsJsonObject());
			}
		}
		if (jsonObject.has("languageCode")) {
			JsonElement jsonLanguageCode = jsonObject.get("languageCode");
			if (jsonLanguageCode != null) {
				languageCode = jsonLanguageCode.getAsString();
			}
		}
		if (jsonObject.has("title")) {
			JsonElement jsonTitle = jsonObject.get("title");
			if (jsonTitle != null) {
				title = jsonTitle.getAsString();
			}
		}
		if (jsonObject.has("description")) {
			JsonElement jsonDescription = jsonObject.get("description");
			if (jsonDescription != null) {
				description = jsonDescription.getAsString();
			}
		}
		if (jsonObject.has("releaseNotes")) {
			JsonElement jsonReleaseNotes = jsonObject.get("releaseNotes");
			if (jsonReleaseNotes != null) {
				releaseNotes = jsonReleaseNotes.getAsString();
			}
		}
		if (jsonObject.has("companyUrl")) {
			JsonElement jsonCompanyUrl = jsonObject.get("companyUrl");
			if (jsonCompanyUrl != null) {
				companyUrl = jsonCompanyUrl.getAsString();
			}
		}
		if (jsonObject.has("supportUrl")) {
			JsonElement jsonSupportUrl = jsonObject.get("supportUrl");
			if (jsonSupportUrl != null) {
				supportUrl = jsonSupportUrl.getAsString();
			}
		}
		if (jsonObject.has("screenshotUrl1")) {
			JsonElement jsonScreenshotUrl1 = jsonObject.get("screenshotUrl1");
			if (jsonScreenshotUrl1 != null) {
				screenshotUrl1 = jsonScreenshotUrl1.getAsString();
			}
		}
		if (jsonObject.has("screenshotUrl2")) {
			JsonElement jsonScreenshotUrl2 = jsonObject.get("screenshotUrl2");
			if (jsonScreenshotUrl2 != null) {
				screenshotUrl2 = jsonScreenshotUrl2.getAsString();
			}
		}
		if (jsonObject.has("screenshotUrl3")) {
			JsonElement jsonScreenshotUrl3 = jsonObject.get("screenshotUrl3");
			if (jsonScreenshotUrl3 != null) {
				screenshotUrl3 = jsonScreenshotUrl3.getAsString();
			}
		}
		if (jsonObject.has("screenshotUrl4")) {
			JsonElement jsonScreenshotUrl4 = jsonObject.get("screenshotUrl4");
			if (jsonScreenshotUrl4 != null) {
				screenshotUrl4 = jsonScreenshotUrl4.getAsString();
			}
		}
		if (jsonObject.has("screenshotWidthHeight1")) {
			JsonElement jsonScreenshotWidthHeight1 = jsonObject
					.get("screenshotWidthHeight1");
			if (jsonScreenshotWidthHeight1 != null) {
				screenshotWidthHeight1 = jsonScreenshotWidthHeight1
						.getAsString();
			}
		}
		if (jsonObject.has("screenshotWidthHeight2")) {
			JsonElement jsonScreenshotWidthHeight2 = jsonObject
					.get("screenshotWidthHeight2");
			if (jsonScreenshotWidthHeight2 != null) {
				screenshotWidthHeight2 = jsonScreenshotWidthHeight2
						.getAsString();
			}
		}
		if (jsonObject.has("screenshotWidthHeight3")) {
			JsonElement jsonScreenshotWidthHeight3 = jsonObject
					.get("screenshotWidthHeight3");
			if (jsonScreenshotWidthHeight3 != null) {
				screenshotWidthHeight3 = jsonScreenshotWidthHeight3
						.getAsString();
			}
		}
		if (jsonObject.has("screenshotWidthHeight4")) {
			JsonElement jsonScreenshotWidthHeight4 = jsonObject
					.get("screenshotWidthHeight4");
			if (jsonScreenshotWidthHeight4 != null) {
				screenshotWidthHeight4 = jsonScreenshotWidthHeight4
						.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotUrl1")) {
			JsonElement jsonIpadScreenshotUrl1 = jsonObject
					.get("ipadScreenshotUrl1");
			if (jsonIpadScreenshotUrl1 != null) {
				ipadScreenshotUrl1 = jsonIpadScreenshotUrl1.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotUrl2")) {
			JsonElement jsonIpadScreenshotUrl2 = jsonObject
					.get("ipadScreenshotUrl2");
			if (jsonIpadScreenshotUrl2 != null) {
				ipadScreenshotUrl2 = jsonIpadScreenshotUrl2.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotUrl3")) {
			JsonElement jsonIpadScreenshotUrl3 = jsonObject
					.get("ipadScreenshotUrl3");
			if (jsonIpadScreenshotUrl3 != null) {
				ipadScreenshotUrl3 = jsonIpadScreenshotUrl3.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotUrl4")) {
			JsonElement jsonIpadScreenshotUrl4 = jsonObject
					.get("ipadScreenshotUrl4");
			if (jsonIpadScreenshotUrl4 != null) {
				ipadScreenshotUrl4 = jsonIpadScreenshotUrl4.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotWidthHeight1")) {
			JsonElement jsonIpadScreenshotWidthHeight1 = jsonObject
					.get("ipadScreenshotWidthHeight1");
			if (jsonIpadScreenshotWidthHeight1 != null) {
				ipadScreenshotWidthHeight1 = jsonIpadScreenshotWidthHeight1
						.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotWidthHeight2")) {
			JsonElement jsonIpadScreenshotWidthHeight2 = jsonObject
					.get("ipadScreenshotWidthHeight2");
			if (jsonIpadScreenshotWidthHeight2 != null) {
				ipadScreenshotWidthHeight2 = jsonIpadScreenshotWidthHeight2
						.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotWidthHeight3")) {
			JsonElement jsonIpadScreenshotWidthHeight3 = jsonObject
					.get("ipadScreenshotWidthHeight3");
			if (jsonIpadScreenshotWidthHeight3 != null) {
				ipadScreenshotWidthHeight3 = jsonIpadScreenshotWidthHeight3
						.getAsString();
			}
		}
		if (jsonObject.has("ipadScreenshotWidthHeight4")) {
			JsonElement jsonIpadScreenshotWidthHeight4 = jsonObject
					.get("ipadScreenshotWidthHeight4");
			if (jsonIpadScreenshotWidthHeight4 != null) {
				ipadScreenshotWidthHeight4 = jsonIpadScreenshotWidthHeight4
						.getAsString();
			}
		}
	}
}