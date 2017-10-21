package br.edu.ifsp.spo.model;

import java.io.File;

import javafx.beans.property.*;

public class Exercise {

	final private StringProperty exerciseName;
	final private StringProperty exerciseSended;
	final private ObjectProperty<File> exerciseDescription;

	public Exercise() {
		this(null, null, null);
	}

	public Exercise(String exerciseName, String exerciseSended, String path) {
		this.exerciseName = new SimpleStringProperty(exerciseName);
		this.exerciseSended = new SimpleStringProperty(exerciseSended);
		this.exerciseDescription = new SimpleObjectProperty<File>(new File(path));
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

	public File getExerciseDescription() {
		return exerciseDescription.get();
	}

	public void setExerciseDescription(File exerciseDescription) {
		this.exerciseDescription.set(exerciseDescription);;
		;
	}

	public ObjectProperty<File> exerciseDescriptionProperty(){
		return exerciseDescription;
	}

}
