# language: pl
Funkcja: Dowiedz się, o której godzinie odjeżdżają nastepne pociągi do stacji docelowej
	W celu bardziej efektywnego planowania podróży
	Jako podróżny
	Chcę się dowiedzieć, jakie następne pociągi odjeżdżają do mojej stacji docelowej

Scenariusz: Znajdź optymalną trasę pomiędzy stacjami na tej samej linii.
	Zakładając, że chce się dostaż z <skad> do <dokad>
	I następny pociąg odjeżdża o <godzodjazdu> na lini <linia>
	Gdy zapytam o godzine przyjazdu
	Wtedy powinienem uzyskać następujący szacowany czas przyjazdu: <godzprzyjazdu>
		
		|  skad			| dokad		| godzodjazdu	| linia 	| godzprzyjazdu |
		|	Parramatta	| TownHall 	| 8:02 			| Western 	| 8:29 			|
		|	Epping		| Central 	| 8:03 			| Northern 	| 8:48 			|
		|	Epping		| Central 	| 8:07 			| Newcastle | 8:37 			|
		|	Epping		| Central 	| 8:07 			| Newcastle | 8:37 			|
		|	Epping		| Central 	| 8:13 			| Epping 	| 8:51 			|

	