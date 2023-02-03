package z_mapas_coordenadas;

public class RespuestaAPI {

	private double latitude;
	private double longitude;
	private String type;
	private String name;
	private int number;
	private int postal_code;
	private String street;
	private double confidence;
	private String region;
	private String region_code;
	private String county;
	private String locality;
	private String administrative_area;
	private String neighbourhood;
	private String country;
	private String country_code;
	private String continent;
	private String label;
	
	public RespuestaAPI(double latitude, double longitude, String type, String name, int number, int postal_code,
			String street, double confidence, String region, String region_code, String county, String locality,
			String administrative_area, String neighbourhood, String country, String country_code, String continent,
			String label) {

		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
		this.name = name;
		this.number = number;
		this.postal_code = postal_code;
		this.street = street;
		this.confidence = confidence;
		this.region = region;
		this.region_code = region_code;
		this.county = county;
		this.locality = locality;
		this.administrative_area = administrative_area;
		this.neighbourhood = neighbourhood;
		this.country = country;
		this.country_code = country_code;
		this.continent = continent;
		this.label = label;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrative_area() {
		return administrative_area;
	}

	public void setAdministrative_area(String administrative_area) {
		this.administrative_area = administrative_area;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Respuesta [latitude=" + latitude + ", longitude=" + longitude + ", type=" + type + ", name=" + name
				+ ", number=" + number + ", postal_code=" + postal_code + ", street=" + street + ", confidence="
				+ confidence + ", region=" + region + ", region_code=" + region_code + ", county=" + county
				+ ", locality=" + locality + ", administrative_area=" + administrative_area + ", neighbourhood="
				+ neighbourhood + ", country=" + country + ", country_code=" + country_code + ", continent=" + continent
				+ ", label=" + label + "]";
	}

}
