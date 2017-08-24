package br.edu.ifsp.spo.model;

import javafx.beans.property.*;

public class Exercise {

	final private StringProperty exerciseName;
	final private StringProperty exerciseSended;

	public Exercise() {
		this(null, null);
	}

	public Exercise(String exerciseName, String exerciseSended) {
		this.exerciseName = new SimpleStringProperty(exerciseName);
		this.exerciseSended = new SimpleStringProperty(exerciseSended);
	}

	public String getExerciseName() {
		return exerciseName.get();
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName.set(exerciseName);
		;
	}

	public StringProperty exerciseNameProperty() {
		return exerciseName;
	}

	public String getExerciseSended() {
		return exerciseSended.get();
	}

	public void setExerciseSended(String exerciseSended) {
		this.exerciseSended.set(exerciseSended);
	}

	public StringProperty exerciseSendedProperty() {
		return exerciseSended;
	}

}
