package com.ice1155.BL;

import com.ice1155.UI.R;
import com.ice1155.UI.ViewEjerciciosActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class OnItemClickListenerListViewItem implements OnItemClickListener {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		TextView idEjercicio = (TextView) view
				.findViewById(R.id.txtIdEjercicio);
		TextView zona = (TextView) view.findViewById(R.id.lblNombreZona);
		TextView descripcion = ViewEjerciciosActivity.descripcion;

		AnimationDrawable ad = new AnimationDrawable();
		ImageView imgEjercicio = ViewEjerciciosActivity.imgEjercicio;

		// Switch encargado de enviar el id del ejercicio para renderizarlo en
		// la vista perfil del ejercicio
		switch (Integer.valueOf((String) idEjercicio.getText())) {
		// Ejercicios para abdominales
		case 1:
			idEjercicio.setText("" + 1);

			descripcion
					.setText("Acostado sobre una colchoneta con la cabeza apoyada en el AB trainer se hace contracciones abdominales levantando los hombros del suelo manteniendo la cabeza alineada (unos 20 grados del suelo hacia arriba).");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.at1_1), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();

			break;
		case 2:
			idEjercicio.setText("" + 2);

			descripcion
					.setText("Colgado en una barra, con los brazos estirados, realizamos una flexión de cadera subiendo las piernas flexionadas hasta llegar a la horizontal. Lentamente volvemos a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.epc2_1), 1000);
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();

			break;
		case 3:
			idEjercicio.setText("" + 3);

			descripcion
					.setText("Boca arriba con las rodillas flexionadas y los pies completamente apoyados en el suelo, separados el ancho de las caderas. Cuando inicie a expulsar el aire, mueve lentamente la cabeza y el tronco hacia las rodillas hasta que las escápulas se separen del suelo. Detente un instante y regresa a la posición inicial al tiempo que coges aire.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.crun3_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.crun3_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 4:
			idEjercicio.setText("" + 4);

			descripcion
					.setText("En una colchoneta y apoyado en el Ab trainer realizamos un flexión lateral del tronco contrayendo y estirando nuestros musculos abdominales oblicuos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.at1_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 5:
			idEjercicio.setText("" + 5);

			descripcion
					.setText("Apoyamos nuestros pies la bola y flexionamos las piernas y subimos. Este ejercicio es bastante fácil de hacer y muy positivo para el músculo. Nuestro abdomen se fortalecerá y marcará positivamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecb5_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecb5_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 6:
			idEjercicio.setText("" + 6);

			descripcion
					.setText("Sobre la bola, apoyandonos con la zona de la espalda baja, las piernas separadas para estabilizar el ejercicio. Realizamos la flexión de tronco hacia arriba, hasta dejar solo la zona lumbar sobre la bola de pilates. Es muy importante realizar el ejercicio lenta y controladamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cb6_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cb6_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 7:
			idEjercicio.setText("" + 7);

			descripcion
					.setText("Sobre la bola de pilates realizamos un flexión lateral del tronco hasta sentir el estiramiento de nuestros musculos abdominales oblicuos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ocb7_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ocb7_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios para piernas
		case 8:
			idEjercicio.setText("" + 8);

			descripcion
					.setText("Inspiramos y realizamos una flexión de caderas y rodillas hasta llegar a que los gluteos se acerquen a las pantorillas, desde esa posición realizamos una extensión de caderas y rodillas hasta la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.sen8_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.sen8_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 9:
			idEjercicio.setText("" + 9);

			descripcion
					.setText("De pie con una pierna adelantada y la otra retrasada, con la barra sobre los hombros, realizaremos una flexión de piernas hasta llevar la rodilla de la pierna retrasada al suelo. La pierna adelantada se flexionará un máximo de 90 º.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.dcb9_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.dcb9_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 10:
			idEjercicio.setText("" + 10);

			descripcion
					.setText("Sentado en la maquina, nos sujetamos con las manos en las manetas, desde esa posición estable realizamos una extensión de la rodilla de manera lenta y controlada, al llegar a la posición más alta nos detenemos un instante y descendemos lentamente hasta la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.edr10_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.edr10_2), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 11:
			idEjercicio.setText("" + 11);

			descripcion
					.setText("En la máquina específica para su realización, acostado boca abajo con los tobillos justo debajo de los cojines y las manos sujetando los agarres que se encuentran debajo del banco de apoyo. Previamente cargamos la máquina con el peso que deseamos y comenzamos inspirando mientras flexionamos las rodillas para elevar con los tobillos el peso cargado.\nEstiramos cuando la rodilla está flexionada y los talones se encuentran cerca de los glúteos y comenzamos a regresar a la posición inicial controlando el movimiento.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.fr11_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.fr11_2), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 12:
			idEjercicio.setText("" + 12);

			descripcion
					.setText("Sentado en la maquina, realizamos una extensión de la rodilla derecha de manera lenta y controlada, al llegar a la posición más alta nos detenemos un instante y descendemos lentamente has ta la posición inicial. Luego con la rodilla izquierda.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.eri12_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.eri12_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 13:
			idEjercicio.setText("" + 13);

			descripcion
					.setText("Primero escojamos el peso que deseamos levantar  y posicionémosnos en la máquina con las piernas debajo de la almohadilla (pies apuntando hacia adelante) y las manos sosteniendo las barras laterales.\nUtilizando únicamente los cuádriceps, extendamos las piernas al máximo mientras exhalamos. Nos deberemos asegurar de que el resto del cuerpo permanece inmóvil en el asiento.\nBajaremos lentamente el peso hacia atrás a la posición inicial mientras inhalamos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.erp13_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.erp13_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 14:
			idEjercicio.setText("" + 14);

			descripcion
					.setText("Sentado y sujetando con las manos al asiento, apoyamos la zona lumbar en el respaldo y colocamos la cara interna de las rodillas por detrás de los cojines con los cuales debemos movilizar el peso y desde allí comenzamos el movimiento.\nJuntamos los muslos de manera que las rodillas o los cojines que están delante de ellas se unan en el centro, delante nuestro. Sostenemos la posición unos segundos y lentamente regresamos a la posición inicial, sin movimientos bruscos y conservando durante todo el recorrido la espalda bien apoyada en la máquina.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.mda14_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.mda14_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 15:
			idEjercicio.setText("" + 15);

			descripcion
					.setText("Sentarnos en la máquina específica para su realización previa carga del peso a utilizar. Colocamos las piernas juntas y flexionadas y en la cara externa de las mismas, justo a la altura de las rodillas, deben quedar los cojines de la máquina. Desde allí se inicia el movimiento.\nDebemos separar las piernas al máximo mientras empujamos los cojines que están sobre la cara externa de nuestras piernas y después, regresar lentamente a la posición inicial hasta juntar las piernas nuevamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.mda15_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.mda15_2), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 16:
			idEjercicio.setText("" + 16);

			descripcion
					.setText("De pie frente a la máquina, nos sujetamos de los soportes de manera que estemos estables, apoyamos la parte exterior del muslo en el rodillo y desde esa posición realizamos una abducción de la pierna que trabaja, el resto del cuerpo permanece estable durante todo el ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.mh16_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 17:
			idEjercicio.setText("" + 17);

			descripcion
					.setText("Apoyamos la espalda contra el respaldo, quitaremos el seguro que soporta el peso . Inspiraremos y realizaremos una flexión de rodillas haciendo descender la plataforma hasta formar una ángulo de 90 grados con las rodillas. Luego empujaremos la plataforma hacia arriba hasta la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pren17_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pren17_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 18:
			idEjercicio.setText("" + 18);

			descripcion
					.setText("Con los pies separados aproximadamente de la anchura de los hombros y las rodillas ligeramente flexionadas debemos despegar los talones del suelo mientras realizamos una extensión de los pies para elevar el cuerpo mientras éste queda sostenido por la punta del pie.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cb18_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cb18_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 19:
			idEjercicio.setText("" + 19);

			descripcion
					.setText("Colocar los dedos de los pies de tal manera que podamos estirar el gemelo a tope en la posición inicial, y separados a la anchura de los hombros. Mantener las piernas estiradas para reducir la actividad del cuadríceps, pero sin bloquear las rodillas para evitar el estrés sobre la articulación.Descender de manera controlada hasta el punto donde consigáis un buen estiramiento, y luego subid sobre los dedos de los pies lo más alto posible. Me gusta mantener la posición contraída durante unos instantes antes de pasar a la próxima repetición.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cm19_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cm19_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios para gemelos
		case 20:
			idEjercicio.setText("" + 20);

			descripcion
					.setText("Colócate en la posición correcta del aparato de elevación de talones: centra el cuerpo en el asiento y mantén el torso erguido.\nColoca los pies sobre la plataforma de manera que el empeine esté en contacto con ella y los talones puedan moverse con libertad durante todo el intervalo de recorrido. Mantén los dedos de los pies apuntando siempre hacia el frente.\nToma aire y retenlo mientras subes los talones lo más lato posible.\nMantén la posición final durante dos o tres segundos, expulsa el aire y baja controladamente los talones hasta que queden por debajo del empeine.\nUna vez alcanzada la posición baja, revertid la dirección del movimiento.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ms20_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 21:
			idEjercicio.setText("" + 21);

			descripcion
					.setText("Acostado en un banco plano con la cabeza, la espalda y los pies apoyados, se debe sujetar la barra simétricamente con un agarre más ancho que los hombros, sobre la vertical de los ojos, preferiblemente con el pulgar por debajo de la barra. Se desciende con los codos en vertical con las muñecas hasta que la barra quede a dos dedos de la parte media superior del pecho y se vuelve a subir verticalmente.\nHay que vigilar no arquear la espalda, no rebota la barra sobre el pecho y no bloquear los codos cuando están extendidos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbp21_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbp21_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 22:
			idEjercicio.setText("" + 22);

			descripcion
					.setText("Acostado sobre banco plano, cogemos las mancuernas con una agarre en supinación y extendemos los brazos rectos sobre nuestro pecho y a la anchura de los hombros.\nDesde esa posición bajamos las mancuernas hasta que los brazos formen una ángulo de 90 grados y a continuación subimos a la posición inicial. ");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbp22_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbp22_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios de pectorales
		case 23:
			idEjercicio.setText("" + 23);

			descripcion
					.setText("Sentado en un banco inclinado, el respaldo lo colocamos entre 45º y 60º, tomamos la barra con las manos en pronación separadas a una longitud superior a la de los hombros, inspirar y bajar la barra hasta el esternón.\nExpirar para subir la barra e inspirar al descender.\nDebemos mantener bien pegada la zona lumbar al respaldo y no la arquearmos en ningún momento del ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbi23_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbi23_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 24:
			idEjercicio.setText("" + 24);

			descripcion
					.setText("Con dos mancuernas de un mismo peso, nos acostamosen el banco con el glúteo bien apoyado en el asiento, la espalda recostada sobre el banco y los pies firmemente colocados en el suelo.\nCon o sin ayuda, levantaremos las mancuernas hasta arriba, llegando a extender completamente los codos. Una vez tengamos controlado el peso, comenzaremos a descender de forma controlada hasta casi llevar las mancuernas a nuestro pecho, flexionando poco a poco los brazos, metiendo los codos levemente hacia adentro.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbi24_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbi24_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 25:
			idEjercicio.setText("" + 25);

			descripcion
					.setText("Acostado en un banco declinado cogemos la barra desde el soporte con una anchura similar a la anchura de los hombros, desde esa posición realizamos una extensión de los brazosy luego regresando a la posición unicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbd25_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbd25_2), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 26:
			idEjercicio.setText("" + 26);

			descripcion
					.setText("Acostado en un banco declinado, cogemos las mancuernas con una agarre en supinación, los brazos permanecen con una ligera flexión durante todo el ejercicio, partimos con los brazos paralelos al suelo y cerramos los brazos hasta que las mancuernas se toquen en la parte más alta, lentamente volvemos a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbd26_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbd26_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 27:
			idEjercicio.setText("" + 27);

			descripcion
					.setText("Ajusta la altura del asiento para que los agarres queden a la altura de los hombros o un poco por debajo. Siéntate erguido con la espalda contra el acolchado y coloca los pies sobre el suelo directamente bajo las rodillas y separados aproximadamente a la anchura de los hombros.\nSujeta los agarres con las palmas mirando hacia fuera. Toma aire y aguanta la respiración mientras empujas para llevar los agarres lejos del cuerpo.\nExpulsa el aire después de pasar la parte más difícil del movimiento o cuando los brazos estén completamente extendidos.\nHaz una pequeña pausa y regresa a la posición inicial. Cuando las manos se aproximen a la altura del pecho cambia el sentido del movimiento y repite.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pvr27_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pvr27_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 28:
			idEjercicio.setText("" + 28);

			descripcion
					.setText("Acostado en banco plano maquina, la colocación de las manos deberá estar en la prolongación del antebrazo.\nDesde esa posición bajamos las barras hasta que los brazos formen una ángulo de 90 grados y a continuación subimos a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ppm28_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 29:
			idEjercicio.setText("" + 29);

			descripcion
					.setText("Sentado en la maquina declinado sujeta los agarres desde el soporte con una anchura similar a la anchura de los hombros, desde esa posición realizamos una extensión de los brazos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pib29_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pib29_2), 1000);

			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 30:
			idEjercicio.setText("" + 30);

			descripcion
					.setText("De espalda sobre un banco plano con mancuernas en ambas manos las palmas deben mirar hacia el centro del cuerpo y manteniendo los brazos levemente flexionados en vertical al cuerpo, sobre el pecho, inspiramos y separamos los brazos del cuerpo hasta llegar a la altura de los hombros y que los codos pasen más abajo que estos, es decir, mantenemos los brazos alineados entre sí, perpendicular al cuerpo y paralelos al suelo.\nMientras espiramos regresamos al centro del cuerpo ambos brazos sin extender ni flexionar más los codos, las mancuernas deben quedar enfrentadas arriba del pecho como en la posición inicial del ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.apm30_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.apm30_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 31:
			idEjercicio.setText("" + 31);

			descripcion
					.setText("Colocando una banca, plana o bien inclinada, entre la maquina de polea y acostado, al tiempo que toma con cada mano un tirador de cada lado y por tanto los brazos están abiertos en cruz.\nJuntando los brazos, manteniendo una ligera flexión de los codos, hasta que las manos se toquen arriba.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.apc31_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.apc31_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 32:
			idEjercicio.setText("" + 32);

			descripcion
					.setText("Acostado boca abajo se colocan las manos en el suelo un poco más allá del ancho de los hombros. Dedos dirigidos hacia adelante.\nSe apoyan las puntas de los pies en el suelo.\nActiva el centro abdominal, apretando el ombligo hacia la columna vertebral.\nSe extienden los brazos. Alinea la espalda de manera que forme una línea continua entre los talones y los hombros. Esa es la posición inicial.\nSe baja el pecho, flexionando los brazos, y sube a la posición inicial. Repite el número de veces necesarias.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pu32_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pu32_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 33:
			idEjercicio.setText("" + 33);

			descripcion
					.setText("De pie, colocado lateralmente a la maquina,cogemos la manilla con un agarre prono, y los brazos horizontal al suelo, realizamos una aducción de hombros llevando las manos delante del cuerpo, los brazos no cambia su flexión en ningún momento.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ahh33_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ahh33_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 34:
			idEjercicio.setText("" + 34);

			descripcion
					.setText("De pie entre las dos poleas, cogemos las manillas con una agarre prono, iniciamos el ejercicio con los brazos arriba y con una flexión de 90º, ahora realizamos un cruce de las poleas delante de nosotros. Lentamente volvemos a la posición inicial.Los brazos mantienen la flexión durante todo el ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.avc34_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.avc34_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 35:
			idEjercicio.setText("" + 35);

			descripcion
					.setText("Tomado de una barra fija con las manos de manera que las mismas queden separadas más allá del ancho de los hombros y las palmas miren hacia afuera (agarre en pronación), desde allí, con las rodillas flexionadas pero con las piernas relajadas y todo el cuerpo sostenido pero estirado.\nInspiramos y efectuamos una tracción de manera de elevar el cuerpo entero mediante la flexión de los brazos y la contracción de los músculos de la espalda, hasta que la cabeza quede a la altura de la barra, pudiendo pasar ésta por detrás de la nuca o por el frente de la cara.\nEstiramos al final del movimiento y descendemos de manera controlada hasta que los brazos queden totalmente estirados nuevamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.bfa35_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.bfa35_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 36:
			idEjercicio.setText("" + 36);

			descripcion
					.setText("Colgado de la barra fija y con las manos muy separadas, inspiramos y levantamos nuestro cuerpo hasta casi tocar la barra con la barbilla. Hay otro modo de hacerlo que es por detrás de la nuca.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.bfl36_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.bfl36_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 37:
			idEjercicio.setText("" + 37);

			descripcion
					.setText("De pie, rodillas ligeramente flexionadas, tronco inclinado 45º, espalda bien recta, barra asida en pronación, manos separadas una distancia mayor a la anchura de los hombros, brazos colgando, inspirar, efectuar un bloqueo respiratorio y una contracción isométrica de la banda abdominal, tirar de la barra hasta el pecho y volver a la posición de partida y espirar.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcb37_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcb37_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios de espalda
		case 38:
			idEjercicio.setText("" + 38);

			zona.setText("Espalda");
			descripcion
					.setText("De pie, sujetando una barra con agarre invertido y los brazos totalmente extendidos a lo largo de cuerpo.\nInclínate hacia el frente desde las caderas, manteniendo siempre arqueada la espalda baja, hasta que la espalda forme aproximadamente un ángulo de 45 grados respecto al suelo.\nDejar que los brazos se muevan hacia adelante naturalmente de manera que cuelguen verticalmente bajo los hombros. Doblando las rodillas para mantener el equilibrio.\nTomar aire y retenerlo mientras se tira de la barra hacia la cintura.\nTirar de la barra hasta que toque o se acerque a la cintura con los codos por detrás del nivel de la espalda.\nExpulsar el aire al regresar al punto de partida.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rbi38_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.rbi38_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 39:
			idEjercicio.setText("" + 39);

			descripcion
					.setText("Coloca tu rodilla y mano sobre un banco y coge una mancuerna con tu otra mano.\nEleva la mancuerna sin mover otra cosa que tu brazo y bájala luego de una breve pausa.\nExhala al levantar la mancuerna e inhala al retornar a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcm39_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcm39_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 40:
			idEjercicio.setText("" + 40);

			descripcion
					.setText("Sujete los agarres de la máquina con los brazos extendidos, apoyando el pecho contra el soporte acolchado. Empuje los agarres hacia la parte superior del pecho, manteniendo la columna vertebral recta en todo momento. Vuelva lentamente a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rm40_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 41:
			idEjercicio.setText("" + 41);

			descripcion
					.setText("Sentado de cara al aparato, pies anclados, tronco flexionado, inspirer y llevar el mango hasta la base del esternón enderezando la espalda y tirando los codos hacia atrás lo más lejos posible.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcc41_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.rcc41_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 42:
			idEjercicio.setText("" + 42);

			descripcion
					.setText("Sentado en el asiento, con las rodillas bien sujetas en los rodillos, el cuerpo debe estar inclinado atrás ligeramente, iniciamos el ejercicio con los brazos estirados arriba y tiramos de la polea hasta llevarlas unidas frente al pecho, lentamente volvemos a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.jpa42_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.jpa42_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 43:
			idEjercicio.setText("" + 43);

			descripcion
					.setText("Nos sentamos y ajustamos el asiento y los rodillos en las rodillas para mantener una posición estable y evitar que el cuerpo se levante. Cogemos las manillas con un agarre neutro. El cuerpo debemos inclinarlo hacía atrás formando un ángulo de 30º , desde esa posición inicial y con los brazos estirados realizamos un tirón con la musculatura dorsal, apretando los omoplatos y acercamos la barra hacia el pecho, el tronco no debe moverse en todo el ejercicio. Es mejor trabajar con un peso que podamos mover de manera correcta así evitaremos mover el tronco para ayudarnos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.jpc43_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.jpc43_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 44:
			idEjercicio.setText("" + 44);

			descripcion
					.setText("Nos sentamos en la máquina, la zona lumbar realiza una presión hacia el respaldo durante todo el ejercicio. Cogemos los soportes frontales con un agarre neutro, y sin perder la presión abdominal y lumbar bajamos los soportes hasta la extensión casi completa de los codos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.jmc44_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.jmc44_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 45:
			idEjercicio.setText("" + 45);

			descripcion
					.setText("Apoyar el cuerpo sobre el banco en la articulación de la cadera y el fémur, ya que el pubis debe quedar fuera del banco. Desde allí tendremos que flexionar el torso hasta que nuestro cuerpo forme un ángulo de 90 grados. Las manos deben cruzarse delante del torso y mantenerse así durante todo el recorrido.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.hiper45_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.hiper45_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 46:
			idEjercicio.setText("" + 46);

			descripcion
					.setText("Nos colocaremos sentados con una barra cogida en pronación, es decir, con las palmas de las manos mirando hacia atras o hacia abajo cuando colocamos los brazos perpendiculares al cuerpo. Las manos deben estar sobre la barra algo más separadas que la anchura de los hombros. Con la espalda bien recta, llevamos la barra con las manos hasta la parte alta del pecho, casi a la altura de los hombros y desde allí comenzamos el ejercicio.\nInspiramos y elevamos la barra hacia arriba como si la estuviéramos empujando con las manos mientras los brazos se extienden, espiramos al final del movimiento y comenzamos el descenso hacia la posición inicial de manera controlada.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmb46_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmb46_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 47:
			idEjercicio.setText("" + 47);

			descripcion
					.setText("Sentados en un banco, con la espalda bien recta y tomaremos en ambas manos una mancuerna. Llevaremos las mismas a la altura de los hombros por los laterales del cuerpo mientras flexionamos los codos y las palmas de la mano miran hacia adelante.\nDesde los hombros inspiramos y elevamos las mancuernas hasta estirar los brazos hacia arriba, verticalmente. Espiramos al finalizar el movimiento mientras iniciamos el descenso a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmm47_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmm47_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 48:
			idEjercicio.setText("" + 48);

			descripcion
					.setText("De pie, con los pies ligeramente separados y mancuernas asidas con las manos en pronación o palmas hacia abajo, es decir, con el dorso de la mano mirando hacia afuera y los dedos hacia el cuerpo.\nLas mancuernas deben apoyarse junto a las manos sobre los muslos, ligeramente hacia los costados. Inspiramos y comenzamos a contraer los músculos para elevar un brazo hacia adelante mientras espiramos el aire.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.efm48_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.efm48_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 49:
			idEjercicio.setText("" + 49);

			descripcion
					.setText("De pie y separa un poco las piernas. Coge la barra con las manos en pronación y apoyala sobre los muslos. Manten la espalda recta y los abdominales contraidos.\n inspira y eleva la barra con los brazos estirados. Llevala hasta la altura de los ojos. Espira cuando acabes el movimiento y vuelve a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.efb49_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.efb49_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 50:
			idEjercicio.setText("" + 50);

			descripcion
					.setText("De pie, de espaldas a la maquina, con un agarre prono, el brazo casi estirado y junto al cuerpo, elevamos el hombro hasta la horizontal, volvemos lentamente a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.efc50_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.efc50_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios para deltoides
		case 51:
			idEjercicio.setText("" + 51);

			descripcion
					.setText("Con una mancuerna en cada mano, lo deben mantener una pequeña flexión en todo momento. Elevamos los brazos hasta la altura de los hombros, nunca debemos sobre pasar la altura de los hombros.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.elm51_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.elm51_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 52:
			idEjercicio.setText("" + 52);

			descripcion
					.setText("De pie, de espaldas a la maquina, con un agarre supino, realizamos una elevación frontal del hombro, el brazo mantiene la extensión casi completa durante todo el ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.elc52_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.elc52_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 53:
			idEjercicio.setText("" + 53);

			descripcion
					.setText("Siéntate en la máquina cómodamente con los pies por delante y el pecho apoyado.\nAjusta la posición para poder extender completamente los brazos.\nCon un agarre cerrado, flexionaremos los brazos hasta que las manos alcancen la altura de los hombros y se encuentren debajo de estos.\nLa columna debe estar completamente extendida y los hombros hacia atrás intentando juntar las escápulas.\nEl descenso a la posición inicial debe realizarse de forma lenta y controlada.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rmd53_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 54:
			idEjercicio.setText("" + 54);

			descripcion
					.setText("De pie, en el centro de las poleas, cogemos las manillas con un agarre neutro, subimos los brazos estirados hasta la horizontal cruzado y realizando un giro hasta llegar en la posición más alta a tener las palmas hacia arriba ( agarre supino).");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.dpc54_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 55:
			idEjercicio.setText("" + 55);

			descripcion
					.setText("De pie, coge unas mancuernas con un agarre neutral (palmas enfrentadas).\nInclínate al frente doblando las caderas siempre con la espalda ligeramente arqueada. En la posición inicial la espalda debe estar paralela al suelo y las rodillas dobladas, los brazos colgando perpendiculares al suelo.\nToma aire y aguantando la respiración levanta las mancuernas todo lo que puedas llevando el peso hacia afuera.\nEn la posición más alta, los brazos deben sobrepasar el nivel de la espalda todo lo posible. Expulsa el aire mientras bajas los brazos de forma controlada a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.epm55_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.epm55_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 56:
			idEjercicio.setText("" + 56);

			descripcion
					.setText("De pie y separa los pies ligeramente. Flexiona las piernas un poco e inclina el tronco hacia delante. Manten la espalda recta, los brazos cuelgan y con las manos agarra los mangos de las poleas. Cruza los dos cables de la polea.\nInspira y eleva los brazos hasta la horizontal. Desciende a la posición inicial y espira al acabar el movimiento.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.epc56_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.epc56_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 57:
			idEjercicio.setText("" + 57);

			descripcion
					.setText("Coge una barra Z en agarre prono, con las manos separadas a una distancia ligeramente inferior a la anchura de los hombros.\nEstírate boca arriba en un banco horizontal y sostén la barra encima de la frente, con los brazos estirados e inclinados ligeramente.\nSin modificar la posición del húmero, flexiona el codo y baja la barra hasta que el antebrazo supere el plano paralelo al suelo.\nDetente durante un momento, estira el codo y lleva la barra a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pfb57_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pfb57_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 58:
			idEjercicio.setText("" + 58);

			descripcion
					.setText("De pie, tronco derecho, y piernas ligeramente flexionadas. Levante los brazos en vertical, y vuelva los codos hacia adelante. Doble ligeramente los codos, de modo que las piernas queden ligeramente retrasadas, con respecto a la línea del tronco y de los brazos. Baje la pesa hacia atrás, prestando atención a que los codos, no se abran hacia el exterior. Vuelva a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pfm58_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pfm58_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 59:
			idEjercicio.setText("" + 59);

			descripcion
					.setText("Para realizar correctamente la extensión de codo con mancuerna, deberemos agarrar una pesa y, o bien sentarse en un banco press militar o de similar utilidad (con respaldo) o de pie con la espalda recta.\nLevantemos la mancuerna hasta llevarla a la altura del hombros y luego extender el brazo por encima de nuestra cabeza para que el brazo esté perpendicular al suelo.\nBajaremos lentamente la mancuerna por detrás de la cabeza mientras mantenemos el brazo inmóvil. Inhalemos a medida que realizamos este movimiento y pararemos cuando nuestro tríceps esté totalmente estirado.\nVolveremos a la posición inicial flexionando los tríceps mientras exhalamos. Únicamente se moverá el antebrazo. El brazo debe permanecer inmóvil en todo momento al lado de nuestra cabeza.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecm59_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecm59_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 60:
			idEjercicio.setText("" + 60);

			descripcion
					.setText("Sentado en una silla, agarramos una mancuernas con las dos manos y la llevamos por detrás de la cabeza, luego realizamos una extensión de los brazos hacia arriba tratando de que los codos se separen lo menos posible de las orejas, bajamos lentamente y repetimos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmd60_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pmd60_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 61:
			idEjercicio.setText("" + 61);

			descripcion
					.setText("Tome la barra con las manos en pronación con una distancia de entre 6 y 12 pulgadas de separación entre una y otra, y sostenga la barra sobre el esternón con los brazos completamente extendidos.\nLentamente baje la barra hasta su pecho. Asegúrese de mantener los codos doblados cerca del cuerpo, que el brazo forme un ángulo de 45 grados con su cuerpo. Haga una pausa y luego empuje la barra en línea recta hasta la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbc61_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pbc61_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 62:
			idEjercicio.setText("" + 62);

			descripcion
					.setText("De pie frente a la maquina, cogemos la barra con ambas, con los brazos pegados al cuerpo , realizamos una extensión de codos hasta estirar casi completamente los brazos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pd62_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pd62_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 63:
			idEjercicio.setText("" + 63);

			descripcion
					.setText("Inclinado y apoyado en un banco plano, con un agarre neutro de la manilla, el brazo paralelo y sin moverse en todo el ejercicio, realizaremos una extensión de codo hasta llevar el antebrazo a la posición horizontal.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecp63_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecp63_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 64:
			idEjercicio.setText("" + 64);

			descripcion
					.setText("Apoyamos una rodilla en un banco plano y la otra permanecerá semiflexionada apoyada en el suelo.\nNos aseguraremos de que el tronco está en línea recta con la cabeza.\nCon el brazo pegado al tronco y el codo flexionado, iniciamos la extensión mientras espiramos.\nEl movimiento de flexión lo realizaremos mientras inspiramos, evitando que el codo caiga de la altura del tronco.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecm64_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ecm64_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 65:
			idEjercicio.setText("" + 65);

			descripcion
					.setText("De pie frente a la maquina, cogemos la cuerda con ambas manos y un agarre neutro, con los brazos pegados al cuerpo, realizamos una extensión de codos hasta estirar casi completamente los brazos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pdm65_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pdm65_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios para triceps
		case 66:
			idEjercicio.setText("" + 66);

			descripcion
					.setText("De pie frente a la maquina, cogemos la cuerda con una mano y un agarre neutro, con el brazo pegado al cuerpo , realizamos una extensión de codo hasta estirar casi completamente los brazos.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.pdmi66_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.pdmi66_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 67:
			idEjercicio.setText("" + 67);

			descripcion
					.setText("Con los pies ligeramente separados y una ligera flexión de rodillas hacer el movimiento de subida sin mover los codos, la bajada debemos de hacerla de manera controlada y sin llegar a la extensión completa del codo.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbr67_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbr67_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 68:
			idEjercicio.setText("" + 68);

			descripcion
					.setText("De pie pies separados a la altura de los hombros, espalda recta.\nCoja la barra con un agarre ligeramente mas ancha que la altura de los hombros, coja la barra con las manos en supinación (con las palmas hacia arriba).\nLevante la barra de forma controlada hasta lograr una flexión de 145º, con los codos pegados al torso.\nBaje la barra de forma controlada.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbe68_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbe68_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 69:
			idEjercicio.setText("" + 69);

			descripcion
					.setText("Con una mancuerna del mismo peso con cada mano. Extenderemos totalmente los brazos, liberando de tensión a los codos, sin que estén flexionados sujetando las pesas con agarre supino.\nAbriremos las piernas para mejorar nuestra estabilidad y colocaremos la espalda recta y el pecho hacia a fuera. Levantaremos de forma simultánea ambas mancuernas hasta llegar a tocar los hombros. Evitaremos dar tirones innecesarios o movimientos extraños que puedan comprometer nuestra salud.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccm69_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccm69_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 70:
			idEjercicio.setText("" + 70);

			descripcion
					.setText("Colocar los pies al ancho de las caderas y cogeremos una mancuerna en cada mano con los brazos estirados hacia abajo y las manos mirando hacia tu cuerpo. Levantaremos los dos brazos simultáneamente hasta los hombros, manteniendo los codos pegados al cuerpo.\nSi así lo queremos, podemos alternar su realización, primero levantando el peso con un brazo y después con el otro.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccmm70_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccmm70_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 71:
			idEjercicio.setText("" + 71);

			descripcion
					.setText("Sentados en un banco, con ambos pies apoyados en el piso y una mancuerna cogida en una mano de manera que la palma de la misma al sujetar el peso mire hacia arriba, es decir, en supinación. El codo del mismo brazo que sujeta la mancuerna debemos apoyarlo en la cara interna del muslo del mismo lado, mientras el brazo permanece extendido.\nDesde esa posición iniciamos, con el tronco levemente inclinado, el movimiento. Inspiramos y flexionamos el codo para llevar el peso desde el pie hacia la rodilla contraria. Espiramos al final del movimiento y comenzamos un descenso controlado del peso hasta extender el codo nuevamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cc71_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cc71_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 72:
			idEjercicio.setText("" + 72);

			descripcion
					.setText("Colocar una barra enganchada a una polea, en una posición que nos permita colocar los brazos extendidos, emulando la posición de inicio de otros curls.\nCon agarre supino, sujetaremos fuertemente la barra,y con la palma de las manos a la altura de nuestros hombros, con los pies ligeramente abiertos y con las rodillas semiflexionadas (muy ligeramente), comenzaremos a realizar el levantamiento de la barra.\nLlevaremos la barra hasta contraer por completo los brazos, siendo los brazos y no nuestra espalda la que se encarga de ejecutar el levantamiento. Una vez arriba, aguanteremos 1-2 segundos para fomentar la congestión muscular y volveremos, nuevamente, a la posición de partida.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccc72_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccc72_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 73:
			idEjercicio.setText("" + 73);

			descripcion
					.setText("Sentado sobre la máquina, la barra cogida con las manos en supinación, brazos estirados con los codos apoyados sobre el pupitre.\nInspirar y flexionar los codos, espirar al final del movimiento.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.csm73_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.csm73_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 74:
			idEjercicio.setText("" + 74);

			descripcion
					.setText("Sentado en el banco Scott, con los brazos extendidos a lo largo de la zona de apoyo. Coge una barra z por una de las zona donde las manos queden entre supinación y agarre martillo, de esta manera evitaremos sobrecargar los antebrazos, levanta los brazos hasta que los antebrazos queden perpendiculares al suelo y los brazos totalmente apoyados sobre la superficie. Una vez estés arriba aprieta los bíceps y desciende lentamente.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.csb74_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.csb74_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 75:
			idEjercicio.setText("" + 75);

			descripcion
					.setText("Nos inclinamos hacia delante sobre el banco inclinado, apoyamos el brazo, cogemos el agarre con un agarre supino y con el cuerpo bien estable realizamos una flexión de codo acercando la mano a la cabeza. Lentamente volvemos a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.csc75_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.csc75_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 76:
			idEjercicio.setText("" + 76);

			descripcion
					.setText("Sentado en el banco scott, apoyamos el triceps o parte posterior del brazo en el banco y nos inclinamos hasta tener bien apoyada la axila en el borde.\nSe sujeta la barra en supinación (es decir, con la palma hacia arriba).\nEl codo lo tendremos flexionado.\nSe deja bajar el peso hasta unos grados antes de la extensión complete y se sube de nuevo hasta la posición de partida de manera estricta.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.csm76_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.csm76_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 77:
			idEjercicio.setText("" + 77);

			descripcion
					.setText("Toma una mancuerna con cada mano, de pie o sentado, sosteniendo las mancuernas con los brazos extendidos a los lados con las palmas hacia adelante. Dobla tus brazos hacia arriba, deteniéndote a medio camino cuando los antebrazos estén paralelos al suelo y luego baja de nuevo a la posición inicial. Completa siete repeticiones de este movimiento y sin detenerte, levanta la mancuerna hasta los hombros y luego bájala deteniéndote a mitad de camino. Completa siete repeticiones de este movimiento parcial. Termina con otras siete repeticiones de mancuerna con un rango completo de movimiento. Éste se inicia con los brazos completamente extendidos y termina con las pesas en los hombros y los codos flexionados totalmente. Mantén los codos pegados a tus lados durante todo el ejercicio para aislar el bíceps.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccm21_77_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccm21_77_2), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.ccm21_77_3), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;

		// Ejercicios para biceps
		case 78:
			idEjercicio.setText("" + 78);

			descripcion
					.setText("Siéntese en el banco, tome la barra con las palmas mirando hacia abajo y las manos separadas a distancia de los hombros. Descanse el antebrazo en los muslos y permita que las muñecas caigan sobre las rodillas.\nFlexione los nudillos hacia el rostro, levante la barra. Haga una pequeña pausa en el punto máximo de la posición y luego regrese lentamente la barra a la posición inicial.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cfm78_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cfm78_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 79:
			idEjercicio.setText("" + 79);

			descripcion
					.setText("Apóyate sobre un banco con las piernas a la anchura de la cadera. Los antebrazos se apoyan paralelamente sobre los muslos con las muñecas libres. Agarre las mancuernas con los dorsos de las manos hacia arriba ( agarre prono) y deje que la barra baje las muñecas de forma dosificada.\nLa espalda, recta y la cabeza, en prolongación de la espalda.\nLleva ahora las mancuernas hacia arriba con un movimiento uniforme de las muñecas hasta llegar claramente por encima de los antebrazo. Mantén esa posición durante unos instantes y vuelve a bajar las mancuernas de forma controlada.\nDespués de haber subido los pesos lo más posible, baja las manos hasta el punto de partida bajo total control. Los antebrazos deben permanecer en contacto completo con el banco durante el ejercicio.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cfmm79_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 80:
			idEjercicio.setText("" + 80);

			descripcion
					.setText("De rodillas, con los antebrazos apoyados en un banco plano. Las manos sujetan una barra con las palmas hacia abajo-atrás.\nElevar la barra lo mas alto posible, extendiendo las muñecas y sin despegar los antebrazos del banco.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.emb80_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.emb80_2), 1000);
 
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 81:
			idEjercicio.setText("" + 81);

			descripcion
					.setText("De rodillas, con los antebrazos apoyados en un banco plano. Sujeta una mancuerna en cada mano con la palma hacia abajo-atrás.\nElevar las mancuernas lo mas alto posible, extendiendo las muñecas y sin despegar los antebrazos del banco.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.emm81_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.emm81_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 82:
			idEjercicio.setText("" + 82);

			descripcion
					.setText("Mantener los brazos muy extendidos, en flexión de hombro de 90º (es decir, los brazos estirados, rectos hacia delante, quedando el rodillo a la altura de los ojos) y enrollar el peso desde el suelo hasta que esté la cuerda completamente enrollada. Posteriormente, se desenrolla hasta que el peso vuelva a llegar al suelo.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.rol82_1), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 83:
			idEjercicio.setText("" + 83);

			descripcion
					.setText("Sentados en el banco Scott, flexionamos los codos y llevamos las manos (pronación) hacia los hombros.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.csmi83_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.csmi83_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		case 84:
			idEjercicio.setText("" + 84);

			descripcion
					.setText("De pie, en posición estable con las piernas separadas a la anchura de los hombros. Sujetad una barra con agarre prono y las manos también separadas a la altura de los hombros. Dejad que los brazos cuelguen a los lados pero sin bloquearlos, mantened el torso erguido y los hombros hacia atrás. Tomad aire y retenedlo mientras contraéis los flexores de los codos para subir la barra hacia el frente de los hombros. Mantened los brazos en su sitio de manera que los codos no se muevan al subir el peso. Tras alcanzar la posición final mantenedla durante 1 ó 2 segundos, expulsad el aire y bajad la barra controladamente al punto de partida.");

			// Animacion para el 'gif' de muestra
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbi84_1), 1000);
			ad.addFrame(view.getResources().getDrawable(R.drawable.cbi84_2), 1000);
			
			ad.setOneShot(false);
			imgEjercicio.setBackgroundDrawable(ad);
			ad.start();
			break;
		}
	}
}
