package com.myproject.java8.samples.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SalesTerritory {

	private String territoryName;
	private Set<String> geographicExtents;

	public SalesTerritory(String territoryName, Set<String> zipCodes) {
		this.territoryName = territoryName;
		this.geographicExtents = zipCodes;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public Set<String> getGeographicExtents() {
		return geographicExtents != null ? Collections
				.unmodifiableSet(geographicExtents) : Collections.emptySet();
	}

	public void setGeographicExtents(Set<String> geographicExtents) {
		this.geographicExtents = new HashSet<>(geographicExtents);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.territoryName);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SalesTerritory other = (SalesTerritory) obj;
		if (!Objects.equals(this.territoryName, other.territoryName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SalesTerritory{" + "territoryName=" + territoryName
				+ ", geographicExtents=" + geographicExtents + '}';
	}

}
