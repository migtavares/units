# Introduction
This is a library to make using physical units easy.

# Overview
Units are used to relate values to dimensions. For example the dimension Length (or Distance) can use units such as metre, foot or mile.

## Base dimensions / units
The International System of Units (SI) defines seven base dimensions:

+ length (L)
+ mass (M)
+ time (T)
+ electric current (I)
+ thermodynamic temperature (Θ)
+ amount of substance (N)
+ luminous intensity (J)

For each of those dimensions this library provides the corresponding SI unit (and sometimes some other current units). For example for dimension temperature the units celcius, fahrenheit and kelvin are provided.

Each basic unit and each basic dimension are singletons. 

## Derived dimensions / units
All other dimensions and units can be acomplished by a joining base dimensions or units correspondely. 

Dimension example:

+ Volume dimension is composed by the product of 3 length dimensions;
+ Velocity is quotient of a length dimension per time dimension.

Unit example:

+ square meter is a area dimension unit wich is the product of two metre units;
+ foot/s measures velocity and is the quotient of foot and second units.

Creating derived dimensions or units is acomplished by using the static methods of the corresponding factory:

+ `UnitFactory` is used to create derived units;
+ `DimensionFactory` is used to create derived dimensions.

## Prefix units
Units can be prefixed with a multiplyer. For example:

+ kilometre is the unit metre prefixed with the multiplier kilo. 1 km = 1000 m;
+ km² is the unit square unit multiplied by 10^(3*2). 3 is the normal prefix, and the 2 comes from dealing with a dimension that is the product of two base dimensions (Length x Length). 1 km² = 1000000 m².

# Usage
I tried to make this as easy to use as I could but I would be glad to receive comments/ideas/pull requests.

## Basic units
The library already comes with several basic units. To use one just have to use their static method `unit ()` that returns a ready to use, and singleton, unit.

To get a instance of a basic dimension use the method `dimension ()` on any basic dimension class.

## Derived units
Derived units are no singletons. Instead the `UnitFactory` and `DimensionFactory` keep track of the derived units and dimensions in order to gurantee that only one instance of a unit or dimension exists.

*Attention*: None of the two factories is thread safe. I'm not sure if there's any need to make them thread...

## Proguard
When using proguard use the following rule:

	-keepclassmembers class * implements org.bitpipeline.lib.units.Unit {
		static public org.bitpipeline.lib.units.Unit unit();
	}

# License
Copyright 2012 J. Miguel P. Tavares

Licensed under the Apache License, Version 2.0 (the "License")
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
