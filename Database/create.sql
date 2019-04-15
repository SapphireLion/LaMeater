DROP TABLE IF EXISTS Categories;
CREATE TABLE IF NOT EXISTS Categories (
	cid INT,
	name TEXT,
	PRIMARY KEY (cid)
);

DROP TABLE IF EXISTS Meats;
CREATE TABLE IF NOT EXISTS Meats (
	cid INT,
	mid INT,
	name TEXT,
	description TEXT,
	PRIMARY KEY (cid, mid),
	FOREIGN KEY (cid) REFERENCES Categories(cid)
);

DROP TABLE IF EXISTS CookTemps;
CREATE TABLE IF NOT EXISTS CookTemps (
	cid INT,
	mid INT,
	tid INT,
	name TEXT,
	temp INT,
	PRIMARY KEY (cid, mid, tid),
	FOREIGN KEY (cid) REFERENCES Categories(cid),
	FOREIGN KEY (mid) REFERENCES Meats(mid)
);

INSERT INTO Categories VALUES 
	(1, "Beef"),
	(2, "Pork"),
	(3, "Chicken"),
	(4, "Turkey"),
	(5, "Seafood"),
	(6, "Other");

INSERT INTO Meats VALUES
	(1, 1, "Brisket", "Brisket is a cut of meat from the breast or lower chest of beef or veal. Brisket can be cooked many ways, including baking, boiling and roasting. Popular methods in the United States include rubbing with a spice rub or marinating the meat, then cooking slowly over indirect heat from charcoal or wood."),
	(1, 2, "Ribs", "The term 'Ribs' usually refers to the less meaty part of the chops, often cooked as a slab (not cut into separate ribs). They can be roasted, grilled, fried, baked, braised, or smoked."),
	(1, 3, "Ground Beef", "Ground beef, minced beef or beef mince is beef that has been finely chopped with a knife or a meat grinder. It is used in many recipes including hamburgers and spaghetti Bolognese."),
	(1, 4, "Steak", "A meat generally sliced across the muscle fibers, potentially including a bone. Beef steaks are commonly grilled or occasionally fried. Grilled beef steaks can be cooked at different temperatures, or for different lengths of time; the resulting cooked steak ranges from blue (very rare) to overdone"),
	(2, 1, "Ribs", "The term 'Ribs' usually refers to the less meaty part of the chops, often cooked as a slab (not cut into separate ribs). They can be roasted, grilled, fried, baked, braised, or smoked."),
	(2, 2, "Loins", "Pork loin is a cut of meat created from the tissue along the dorsal side of the rib cage. Pork loin may be cut into individual servings, as chops (bone in) or steaks (boneless) which are grilled, baked or fried."),
	(2, 3, "Ham", "Ham is pork from a leg cut that has been preserved by wet or dry curing, with or without smoking. Ham is produced by curing raw pork by salting, also known as dry curing, or brining, also known as wet curing. Additionally, smoking may be employed."),
	(3, 1, "Breast", "These are white meat and are relatively dry."),
	(3, 2, "Wings", "Often served as a light meal or bar food. Buffalo wings are a typical example. Comprises three segments: 'Drumette','Flat', and 'Tip' (often discarded)."),
	(3, 3, "Leg", "Comprised of 2 segments: 'Drumstick' and 'Thigh'");

INSERT INTO CookTemps VALUES
	(1, 1, 1, "Well Done", 190),
	(1, 2, 1, "Well Done", 160),
	(1, 3, 1, "Well Done", 160),
	(1, 4, 1, "Well Done", 155),
	(1, 4, 2, "Medium Well", 145),
	(1, 4, 3, "Medium", 135),
	(1, 4, 4, "Medium Rare", 125),
	(1, 4, 5, "Rare", 120),
	(2, 1, 1, "Well Done", 145);
