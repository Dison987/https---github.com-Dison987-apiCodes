package com.crud.test.rest.languageData;

import java.util.List;


public interface languageDAO {

	public List<language> findAll();

	public int saveLang(language l);
	public language langTypeID(language l);
	public language langProfID(language l);

	public List<language> findLanguage(language l);
	public int deleteLang(language l);
	public int editLang(language l);
}