package edu.iis.mto.bdd.trains.cucumber.steps;

import org.joda.time.LocalTime;

import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.TimetableService;

public class Steps {

	private String linia;
	private String skad;
	private String dokad;
	private LocalTime czasPrzyjazdu;
	private TimetableService timeTableService;

	@Before
	public void setUp() {
		timeTableService = new InMemoryTimetableService();
	}

	@Zakładając("^chcę się dostać z (.*) do (.*)$")
	public void chceSieDostacZMiejscaDoMiejsca(String skad, String dokad) {
		this.skad = skad;
		this.dokad = dokad;
	}

	@I("^następny pociąg odjeżdża o (.*) na lini (.*)$")
	public void nastepnyPociagOdjezdzaONaLini(@Transform(JodaLocalTimeConverter.class) LocalTime czasOdjazdu,
			String linia) {
		this.linia = linia;
		timeTableService.scheduleArrivalTime(linia, czasOdjazdu);
	}

	@Gdy("^zapytam o godzinę przyjazdu$")
	public void zapytamOGodzinePrzyjazdu() {
		czasPrzyjazdu = timeTableService.getArrivalTime(linia, dokad);
	}

	@Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: (.*)$")
	public void powinenemUzuskacSzacowanyCzasPrzyjazdu(
			@Transform(JodaLocalTimeConverter.class) LocalTime czasPrzyjazdu) {
		this.czasPrzyjazdu = czasPrzyjazdu;
	}
}
