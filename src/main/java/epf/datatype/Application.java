//  
//  Application.java
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
import com.googlecode.objectify.annotation.AlsoLoad;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.willshex.gson.shared.Jsonable;

@Cache
@Entity(name = "epf_application")
public class Application extends Jsonable {
	@Id public Long id;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("title") public String title;
	@AlsoLoad("recommended_age") public String recommendedAge;
	@AlsoLoad("artist_name") public String artistName;
	@AlsoLoad("seller_name") public String sellerName;
	@AlsoLoad("company_url") public String companyUrl;
	@AlsoLoad("support_url") public String supportUrl;
	@AlsoLoad("view_url") public String viewUrl;
	@AlsoLoad("artwork_url_large") public String artworkUrlLarge;
	@AlsoLoad("artwork_url_small") public String artworkUrlSmall;
	@AlsoLoad("itunes_release_date") public Date itunesReleaseDate;
	@AlsoLoad("copyright") public String copyright;
	@AlsoLoad("description") public String description;
	@AlsoLoad("version") public String version;
	@AlsoLoad("itunes_version") public String itunesVersion;
	@AlsoLoad("download_size") public Long downloadSize;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonTitle = title == null ? JsonNull.INSTANCE
				: new JsonPrimitive(title);
		object.add("title", jsonTitle);
		JsonElement jsonRecommendedAge = recommendedAge == null
				? JsonNull.INSTANCE : new JsonPrimitive(recommendedAge);
		object.add("recommendedAge", jsonRecommendedAge);
		JsonElement jsonArtistName = artistName == null ? JsonNull.INSTANCE
				: new JsonPrimitive(artistName);
		object.add("artistName", jsonArtistName);
		JsonElement jsonSellerName = sellerName == null ? JsonNull.INSTANCE
				: new JsonPrimitive(sellerName);
		object.add("sellerName", jsonSellerName);
		JsonElement jsonCompanyUrl = companyUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(companyUrl);
		object.add("companyUrl", jsonCompanyUrl);
		JsonElement jsonSupportUrl = supportUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(supportUrl);
		object.add("supportUrl", jsonSupportUrl);
		JsonElement jsonViewUrl = viewUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(viewUrl);
		object.add("viewUrl", jsonViewUrl);
		JsonElement jsonArtworkUrlLarge = artworkUrlLarge == null
				? JsonNull.INSTANCE : new JsonPrimitive(artworkUrlLarge);
		object.add("artworkUrlLarge", jsonArtworkUrlLarge);
		JsonElement jsonArtworkUrlSmall = artworkUrlSmall == null
				? JsonNull.INSTANCE : new JsonPrimitive(artworkUrlSmall);
		object.add("artworkUrlSmall", jsonArtworkUrlSmall);
		JsonElement jsonItunesReleaseDate = itunesReleaseDate == null
				? JsonNull.INSTANCE
				: new JsonPrimitive(itunesReleaseDate.getTime());
		object.add("itunesReleaseDate", jsonItunesReleaseDate);
		JsonElement jsonCopyright = copyright == null ? JsonNull.INSTANCE
				: new JsonPrimitive(copyright);
		object.add("copyright", jsonCopyright);
		JsonElement jsonDescription = description == null ? JsonNull.INSTANCE
				: new JsonPrimitive(description);
		object.add("description", jsonDescription);
		JsonElement jsonVersion = version == null ? JsonNull.INSTANCE
				: new JsonPrimitive(version);
		object.add("version", jsonVersion);
		JsonElement jsonItunesVersion = itunesVersion == null
				? JsonNull.INSTANCE : new JsonPrimitive(itunesVersion);
		object.add("itunesVersion", jsonItunesVersion);
		JsonElement jsonDownloadSize = downloadSize == null ? JsonNull.INSTANCE
				: new JsonPrimitive(downloadSize);
		object.add("downloadSize", jsonDownloadSize);
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
		if (jsonObject.has("title")) {
			JsonElement jsonTitle = jsonObject.get("title");
			if (jsonTitle != null) {
				title = jsonTitle.getAsString();
			}
		}
		if (jsonObject.has("recommendedAge")) {
			JsonElement jsonRecommendedAge = jsonObject.get("recommendedAge");
			if (jsonRecommendedAge != null) {
				recommendedAge = jsonRecommendedAge.getAsString();
			}
		}
		if (jsonObject.has("artistName")) {
			JsonElement jsonArtistName = jsonObject.get("artistName");
			if (jsonArtistName != null) {
				artistName = jsonArtistName.getAsString();
			}
		}
		if (jsonObject.has("sellerName")) {
			JsonElement jsonSellerName = jsonObject.get("sellerName");
			if (jsonSellerName != null) {
				sellerName = jsonSellerName.getAsString();
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
		if (jsonObject.has("viewUrl")) {
			JsonElement jsonViewUrl = jsonObject.get("viewUrl");
			if (jsonViewUrl != null) {
				viewUrl = jsonViewUrl.getAsString();
			}
		}
		if (jsonObject.has("artworkUrlLarge")) {
			JsonElement jsonArtworkUrlLarge = jsonObject.get("artworkUrlLarge");
			if (jsonArtworkUrlLarge != null) {
				artworkUrlLarge = jsonArtworkUrlLarge.getAsString();
			}
		}
		if (jsonObject.has("artworkUrlSmall")) {
			JsonElement jsonArtworkUrlSmall = jsonObject.get("artworkUrlSmall");
			if (jsonArtworkUrlSmall != null) {
				artworkUrlSmall = jsonArtworkUrlSmall.getAsString();
			}
		}
		if (jsonObject.has("itunesReleaseDate")) {
			JsonElement jsonItunesReleaseDate = jsonObject
					.get("itunesReleaseDate");
			if (jsonItunesReleaseDate != null) {
				itunesReleaseDate = new Date(jsonItunesReleaseDate.getAsLong());
			}
		}
		if (jsonObject.has("copyright")) {
			JsonElement jsonCopyright = jsonObject.get("copyright");
			if (jsonCopyright != null) {
				copyright = jsonCopyright.getAsString();
			}
		}
		if (jsonObject.has("description")) {
			JsonElement jsonDescription = jsonObject.get("description");
			if (jsonDescription != null) {
				description = jsonDescription.getAsString();
			}
		}
		if (jsonObject.has("version")) {
			JsonElement jsonVersion = jsonObject.get("version");
			if (jsonVersion != null) {
				version = jsonVersion.getAsString();
			}
		}
		if (jsonObject.has("itunesVersion")) {
			JsonElement jsonItunesVersion = jsonObject.get("itunesVersion");
			if (jsonItunesVersion != null) {
				itunesVersion = jsonItunesVersion.getAsString();
			}
		}
		if (jsonObject.has("downloadSize")) {
			JsonElement jsonDownloadSize = jsonObject.get("downloadSize");
			if (jsonDownloadSize != null) {
				downloadSize = Long.valueOf(jsonDownloadSize.getAsLong());
			}
		}
	}
}