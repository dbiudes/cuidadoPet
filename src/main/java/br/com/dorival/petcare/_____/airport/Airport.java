package br.com.dorival.petcare._____.airport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="airport")
@SuppressWarnings("serial")
public class Airport implements Serializable {
	@Id @GeneratedValue
	private long id;
	private String name;
	private String city;
	private String country;
	@Column(name="iatacode")
	private String iataCode;
	@Column(name="icaocode")
	private String icaoCode;
	private double latitude;
	private double longitude;
	private double altitude;
	@Column(name="offsetutc")
	private double offsetFromUTC;
	@Column(name="dstcode")
	@Enumerated(EnumType.STRING)
	private DSTCode dstCode;
	private String timezone;
	
	public Airport() {
		// default constructor
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getOffsetFromUTC() {
		return offsetFromUTC;
	}

	public void setOffsetFromUTC(double offsetFromUTC) {
		this.offsetFromUTC = offsetFromUTC;
	}

	public DSTCode getDstCode() {
		return dstCode;
	}

	public void setDstCode(DSTCode dstCode) {
		this.dstCode = dstCode;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airport [id=");
		builder.append(id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (country != null) {
			builder.append("country=");
			builder.append(country);
			builder.append(", ");
		}
		if (iataCode != null) {
			builder.append("iataCode=");
			builder.append(iataCode);
			builder.append(", ");
		}
		if (icaoCode != null) {
			builder.append("icaoCode=");
			builder.append(icaoCode);
			builder.append(", ");
		}
		builder.append("latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", altitude=");
		builder.append(altitude);
		builder.append(", offsetFromUTC=");
		builder.append(offsetFromUTC);
		builder.append(", ");
		if (dstCode != null) {
			builder.append("dstCode=");
			builder.append(dstCode);
			builder.append(", ");
		}
		if (timezone != null) {
			builder.append("timezone=");
			builder.append(timezone);
		}
		builder.append("]");
		return builder.toString();
	}
}
