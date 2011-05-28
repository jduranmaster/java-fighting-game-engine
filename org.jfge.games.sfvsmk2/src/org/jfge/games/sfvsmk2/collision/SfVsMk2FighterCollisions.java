package org.jfge.games.sfvsmk2.collision;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jfge.api.collision.CollisionHandler;
import org.jfge.api.collision.CollisionHandlerParser;
import org.xml.sax.SAXException;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * The Class SfVsMk2FighterCollisions.
 */
@Singleton
public final class SfVsMk2FighterCollisions implements Provider<CollisionHandler> {

	/** The collision handler. */
	private CollisionHandler collisionHandler;
	
	/** The collision handler parser. */
	private CollisionHandlerParser collisionHandlerParser;
	
	/**
	 * Instantiates a new sf vs mk2 fighter collisions.
	 *
	 * @param collisionHandlerParser the collision handler parser
	 */
	@Inject
	public SfVsMk2FighterCollisions(CollisionHandlerParser collisionHandlerParser) {
		this.collisionHandlerParser = collisionHandlerParser;
	}
	
	/* (non-Javadoc)
	 * @see com.google.inject.Provider#get()
	 */
	@Override
	public CollisionHandler get() {
		if(collisionHandler == null) {
			try {
				this.collisionHandler = collisionHandlerParser.parseFromXmlFile("/org/jfge/games/sfvsmk2/collision/sfvsmk2FighterCollisions.xml");
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return this.collisionHandler;
	}

}