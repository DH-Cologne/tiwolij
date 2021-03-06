package tiwolij.util;

import java.io.InputStream;
import java.util.Properties;

import de.unihd.dbs.heideltime.standalone.Config;
import de.unihd.dbs.heideltime.standalone.DocumentType;
import de.unihd.dbs.heideltime.standalone.HeidelTimeStandalone;
import de.unihd.dbs.heideltime.standalone.OutputType;
import de.unihd.dbs.heideltime.standalone.POSTagger;
import de.unihd.dbs.uima.annotator.heideltime.resources.Language;

/**
 *
 * A wrapper-class for HeideltimeStandalone. Overrides the readConfigsFile()-
 * Method to avoid using a FileInputStrean
 *
 * @author Alena Geduldig
 *
 */
public class HeideltimeWrapper extends HeidelTimeStandalone {

	public HeideltimeWrapper() {
	}

	public HeideltimeWrapper(Language language) {
		setLanguage(language);
		setDocumentType(DocumentType.NARRATIVES);
		setOutputType(OutputType.TIMEML);
		setPosTagger(POSTagger.NO);
		readConfigFile("/heideltime/config.props");

		initialize(language, DocumentType.NARRATIVES, OutputType.TIMEML, "/heideltime/config.props", POSTagger.NO,
				false);
	}

	/**
	 *
	 * @param language
	 *            language to be processed with the created copy of HeidelTime
	 * @param typeToProcess
	 *            Domain type to be processed
	 * @param outputType
	 *            output type
	 * @param configPath
	 *            path to the configuration file for HeidlTime Standalone
	 * @param posTagger
	 *            POS Tagger to use for preprocessing
	 * @param doIntervalTagging
	 *            whether or not to invoke the IntervalTagger
	 */
	public HeideltimeWrapper(Language language, DocumentType typeToProcess, OutputType outputType, String configPath,
			POSTagger posTagger, Boolean doIntervalTagging) {

		setLanguage(language);
		setDocumentType(typeToProcess);
		setOutputType(outputType);
		setPosTagger(posTagger);
		readConfigFile(configPath);
		initialize(language, typeToProcess, outputType, configPath, posTagger, doIntervalTagging);

	}

	/**
	 * @param configPath
	 *            Path to the configuration file for HeidelTime Standalone
	 */
	public static void readConfigFile(String configPath) {
		InputStream configStream = null;
		try {
			configStream = HeideltimeWrapper.class.getResourceAsStream(configPath);
			Properties props = new Properties();
			props.load(configStream);
			Config.setProps(props);
			configStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
