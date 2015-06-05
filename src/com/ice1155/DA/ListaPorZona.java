package com.ice1155.DA;

public class ListaPorZona {
	// Ejercicios de abdomen-codigo 1
	private ObjectItem[] listAbdomen = new ObjectItem[7];

	// Ejercicios para pierna-codigo 2
	private ObjectItem[] listPierna = new ObjectItem[10];

	// Ejercicios para gemelos-codigo 3
	private ObjectItem[] listGemelos = new ObjectItem[3];

	// Ejercicios para pectorales-codigo 4
	private ObjectItem[] listPectorales = new ObjectItem[14];

	// Ejercicios para espalda-codigo 5
	private ObjectItem[] listEspalda = new ObjectItem[11];

	// Ejercicios para deltoides-codigo 6
	private ObjectItem[] listDeltoides = new ObjectItem[11];

	// Ejercicios para triceps-codigo 7
	private ObjectItem[] listTriceps = new ObjectItem[10];

	// Ejercicios para biceps-codigo 8
	private ObjectItem[] listBiceps = new ObjectItem[11];

	// Ejercicios para antebrazo-codigo 9
	private ObjectItem[] listAntebrazo = new ObjectItem[7];

	// Constructor para llenar los arreglos
	public ListaPorZona() {
		// Abdomen
		listAbdomen[0] = new ObjectItem(1, "Ab-Trainer");
		listAbdomen[1] = new ObjectItem(2, "Elevación piernas colgantes");
		listAbdomen[2] = new ObjectItem(3, "Crunches");
		listAbdomen[3] = new ObjectItem(4, "Ab-trainer oblicuos");
		listAbdomen[4] = new ObjectItem(5, "Elevación con bola");
		listAbdomen[5] = new ObjectItem(6, "Con bola");
		listAbdomen[6] = new ObjectItem(7, "Oblicuos con bola");

		// Piernas
		listPierna[0] = new ObjectItem(8, "Sentadilla");
		listPierna[1] = new ObjectItem(9, "Desplante con barra");
		listPierna[2] = new ObjectItem(10, "Extensión de rodilla");
		listPierna[3] = new ObjectItem(11, "Flexión de rodilla");
		listPierna[4] = new ObjectItem(12, "Extensión rodilla individual");
		listPierna[5] = new ObjectItem(13, "Extensión rodilla platos");
		listPierna[6] = new ObjectItem(14, "Máquina de aductores");
		listPierna[7] = new ObjectItem(15, "Máquina de abductores");
		listPierna[8] = new ObjectItem(16, "Multi hip");
		listPierna[9] = new ObjectItem(17, "Prensa");

		// Gemelos
		listGemelos[0] = new ObjectItem(18, "Con barra");
		listGemelos[1] = new ObjectItem(19, "Con mancuerna");
		listGemelos[2] = new ObjectItem(20, "Máquina sentado");

		// Pectorales
		listPectorales[0] = new ObjectItem(21, "Press de banca plano barra");
		listPectorales[1] = new ObjectItem(22, "Press de banca plano mancuerna");
		listPectorales[2] = new ObjectItem(23, "Press de banca inclinado barra");
		listPectorales[3] = new ObjectItem(24,
				"Press de banca inclinado mancuerna");
		listPectorales[4] = new ObjectItem(25, "Press de banca declinado barra");
		listPectorales[5] = new ObjectItem(26,
				"Press de banca declinado mancuerna");
		listPectorales[6] = new ObjectItem(27,
				"Press vertical r abierto r cerrado");
		listPectorales[7] = new ObjectItem(28, "Press plano máquina");
		listPectorales[8] = new ObjectItem(29, "Press inclinado bidireccional");
		listPectorales[9] = new ObjectItem(30, "Aberturas plano mancuerna");
		listPectorales[10] = new ObjectItem(31, "Aberturas plano cable");
		listPectorales[11] = new ObjectItem(32, "Push-ups");
		listPectorales[12] = new ObjectItem(33,
				"Aducción horizontal hombro cable");
		listPectorales[13] = new ObjectItem(34, "Aducción vertical cable");

		// Espalda
		listEspalda[0] = new ObjectItem(35, "Barra fija auxiliar");
		listEspalda[1] = new ObjectItem(36, "Barra fija libre");
		listEspalda[2] = new ObjectItem(37, "Remo con barra");
		listEspalda[3] = new ObjectItem(38, "Remo con barra invertido");
		listEspalda[4] = new ObjectItem(39, "Remo con mancuerna");
		listEspalda[5] = new ObjectItem(40, "Remo máquina");
		listEspalda[6] = new ObjectItem(41, "Remo con cable");
		listEspalda[7] = new ObjectItem(42, "Jalón polea abierto");
		listEspalda[8] = new ObjectItem(43, "Jalón polea cerrado");
		listEspalda[9] = new ObjectItem(44, "Jalón máquina cerrado");
		listEspalda[10] = new ObjectItem(45, "Hiperextensiones");

		// Deltoides
		listDeltoides[0] = new ObjectItem(46, "Press militar barra");
		listDeltoides[1] = new ObjectItem(47, "Press militar mancuerna");
		listDeltoides[2] = new ObjectItem(48, "Elevación frontal mancuerna");
		listDeltoides[3] = new ObjectItem(49, "Elevación frontal barra");
		listDeltoides[4] = new ObjectItem(50, "Elevación frontal cable");
		listDeltoides[5] = new ObjectItem(51, "Elevación lateral mancuerna");
		listDeltoides[6] = new ObjectItem(52, "Elevación lateral cable");
		listDeltoides[7] = new ObjectItem(53, "Remo máq. deltoide posterior");
		listDeltoides[8] = new ObjectItem(54, "Deltoide posterior cable");
		listDeltoides[9] = new ObjectItem(55, "Elevación posterior mancuerna");
		listDeltoides[10] = new ObjectItem(56, "Elevación posterior cable");

		// Triceps
		listTriceps[0] = new ObjectItem(57, "Press francés barra Z");
		listTriceps[1] = new ObjectItem(58, "Press francés mancuerna");
		listTriceps[2] = new ObjectItem(59, "Extensión codo manc. sentado");
		listTriceps[3] = new ObjectItem(60, "Press mancuerna dos manos");
		listTriceps[4] = new ObjectItem(61, "Press de banca cerrado");
		listTriceps[5] = new ObjectItem(62, "Push down");
		listTriceps[6] = new ObjectItem(63, "Extensión cable (patada)");
		listTriceps[7] = new ObjectItem(64, "Extensión con mancuerna (patada)");
		listTriceps[8] = new ObjectItem(65, "Push down mecate");
		listTriceps[9] = new ObjectItem(66, "Push down mecate individual");

		// Biceps
		listBiceps[0] = new ObjectItem(67, "Curl barra recta");
		listBiceps[1] = new ObjectItem(68, "Curl con barra Z");
		listBiceps[2] = new ObjectItem(69, "Curl con mancuerna");
		listBiceps[3] = new ObjectItem(70, "Curl con mancuerna martillo");
		listBiceps[4] = new ObjectItem(71, "Curl concentrado");
		listBiceps[5] = new ObjectItem(72, "Curl con cable");
		listBiceps[6] = new ObjectItem(73, "Curl Scott máquina");
		listBiceps[7] = new ObjectItem(74, "Curl Scott con barra Z");
		listBiceps[8] = new ObjectItem(75, "Curl Scott con cable");
		listBiceps[9] = new ObjectItem(76, "Curl Scott con mancuerna");
		listBiceps[10] = new ObjectItem(77, "Curl con mancuerna 21");

		// Antebrazo
		listAntebrazo[0] = new ObjectItem(78, "Curl/Flexión de muñeca barra");
		listAntebrazo[1] = new ObjectItem(79,
				"Curl/Flexión de muñeca mancuerna");
		listAntebrazo[2] = new ObjectItem(80, "Extensión de muñeca barra");
		listAntebrazo[3] = new ObjectItem(81, "Extensión de muñeca mancuerna");
		listAntebrazo[4] = new ObjectItem(82, "Rollos");
		listAntebrazo[5] = new ObjectItem(83, "Curl Scott máquina invertido");
		listAntebrazo[6] = new ObjectItem(84, "Curl barra invertido");
	}

	public ObjectItem[] getListAbdomen() {
		return listAbdomen;
	}

	public ObjectItem[] getListPierna() {
		return listPierna;
	}

	public ObjectItem[] getListGemelos() {
		return listGemelos;
	}

	public ObjectItem[] getListPectorales() {
		return listPectorales;
	}

	public ObjectItem[] getListEspalda() {
		return listEspalda;
	}

	public ObjectItem[] getListDeltoides() {
		return listDeltoides;
	}

	public ObjectItem[] getListTriceps() {
		return listTriceps;
	}

	public ObjectItem[] getListBiceps() {
		return listBiceps;
	}

	public ObjectItem[] getListAntebrazo() {
		return listAntebrazo;
	}
}
