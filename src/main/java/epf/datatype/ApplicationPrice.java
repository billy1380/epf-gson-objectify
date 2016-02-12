//  
//  ApplicationPrice.java
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
@Entity(name = "epf_application_price")
public class ApplicationPrice extends Jsonable {
	@Id public String name;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("application_id") @Index public Key<Application> applicationKey;
	@Ignore public Application application;
	@AlsoLoad("retail_price") public Long retailPrice;
	@AlsoLoad("currency_code") public String currencyCode;
	@AlsoLoad("storefront_id") @Index public Key<Storefront> storefrontKey;
	@Ignore public Storefront storefront;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonApplication = application == null ? JsonNull.INSTANCE
				: application.toJson();
		object.add("application", jsonApplication);
		JsonElement jsonRetailPrice = retailPrice == null ? JsonNull.INSTANCE
				: new JsonPrimitive(retailPrice);
		object.add("retailPrice", jsonRetailPrice);
		JsonElement jsonCurrencyCode = currencyCode == null ? JsonNull.INSTANCE
				: new JsonPrimitive(currencyCode);
		object.add("currencyCode", jsonCurrencyCode);
		JsonElement jsonStorefront = storefront == null ? JsonNull.INSTANCE
				: storefront.toJson();
		object.add("storefront", jsonStorefront);
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
		if (jsonObject.has("retailPrice")) {
			JsonElement jsonRetailPrice = jsonObject.get("retailPrice");
			if (jsonRetailPrice != null) {
				retailPrice = Long.valueOf(jsonRetailPrice.getAsLong());
			}
		}
		if (jsonObject.has("currencyCode")) {
			JsonElement jsonCurrencyCode = jsonObject.get("currencyCode");
			if (jsonCurrencyCode != null) {
				currencyCode = jsonCurrencyCode.getAsString();
			}
		}
		if (jsonObject.has("storefront")) {
			JsonElement jsonStorefront = jsonObject.get("storefront");
			if (jsonStorefront != null) {
				storefront = new Storefront();
				storefront.fromJson(jsonStorefront.getAsJsonObject());
			}
		}
	}
}