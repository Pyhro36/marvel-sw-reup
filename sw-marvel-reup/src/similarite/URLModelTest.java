package similarite;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;

public class URLModelTest {

	/* Model = set of triplets
	 * 	Statement = single triplet
	 * 		Resource = subject
	 * 		RDFNode = object
	 * 		Property = predicate
	 * */
	
	private static URLModel urlModel1;
	private static URLModel urlModel2;
	private static URLModel urlModel3;
	private static URLModel urlModel4;
	private static List<Resource> resources1;
	private static List<Resource> resources2;
	private static List<Resource> resources3;
	private static List<Resource> resources4;
	
	/**
	 * @brief Mis en place du banc de test avant les tests
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
		resources1 = new LinkedList<Resource>();
		resources2 = new LinkedList<Resource>();
		resources3 = new LinkedList<Resource>();
		resources3 = new LinkedList<Resource>();
		
		Resource alice = ResourceFactory.createResource("http://example.org/alice");    	
		Resource bob = ResourceFactory.createResource("http://example.org/bob");
		Resource jena = ResourceFactory.createResource("http://example.org/jena");
		
		alice.addProperty(RDF.type, FOAF.Person);
		alice.addProperty(FOAF.name, "Alice");
		alice.addProperty(FOAF.mbox, ResourceFactory.createResource("mailto:alice@example.org"));
		alice.addProperty(FOAF.knows, bob);
		
		bob.addProperty(RDF.type, FOAF.Person);
		bob.addProperty(FOAF.name, "Bob");
		bob.addProperty(FOAF.mbox, ResourceFactory.createResource("mailto:bob@example.org"));
		bob.addProperty(FOAF.knows, alice);
		
		resources1.add(alice);
		resources1.add(bob);
		resources1.add(jena);
		
		urlModel1 = new URLModel(resources1, "1");
		
		Resource alice1 = ResourceFactory.createResource("http://example.org/alice");    
		Resource bob1 = ResourceFactory.createResource("http://example.org/bob");
		
		alice1.addProperty(RDF.type, FOAF.Person);
		alice1.addProperty(FOAF.name, "Alice");
		alice1.addProperty(FOAF.knows, bob);
		
		bob1.addProperty(RDF.type, FOAF.Person);
		bob1.addProperty(FOAF.name, "Bob");
		bob1.addProperty(FOAF.mbox, ResourceFactory.createResource("mailto:bob@example.org"));

		resources2.add(alice1);
		resources2.add(bob1);
		resources2.add(jena);
		
		urlModel2 = new URLModel(resources2, "2");
		
		resources3.add(alice);
		resources3.add(bob1);
		
		urlModel3 = new URLModel(resources3, "3");
		
		resources4.add(alice1);
		resources4.add(bob1);
		
		urlModel4 = new URLModel(resources4, "4");
	}

	/**
	 * Test method for {@link similarite.URLModel#getResources()}.
	 */
	@Test
	public void testGetResources() {
		URLModel urlModel = new URLModel(null, "0");
		assertEquals(urlModel.getResources(), null);
		assertEquals(urlModel1.getResources(), resources1);
		assertEquals(urlModel2.getResources(), resources2);
		assertEquals(urlModel3.getResources(), resources3);
		assertEquals(urlModel4.getResources(), resources4);	
	}

	/**
	 * Test method for {@link similarite.URLModel#getPlusSimilairesURL(java.util.List, int)}.
	 */
	@Test
	public void testGetPlusSimilairesURL() {
		List<URLModel> urlModels = new LinkedList<URLModel>();
		
		urlModels.add(urlModel2);
		urlModels.add(urlModel3);
		urlModels.add(urlModel4);
		
		assertEquals(urlModel1.getPlusSimilairesURL(urlModels, 0).size(), 0);
	}

	/**
	 * Test method for {@link similarite.URLModel#similairiteParSujets(similarite.URLModel)}.
	 */
	@Test
	public void testSimilairiteParSujets() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link similarite.URLModel#similairiteParTriplets(similarite.URLModel)}.
	 */
	@Test
	public void testSimilairiteParTriplets() {
		fail("Not yet implemented");
	}
}