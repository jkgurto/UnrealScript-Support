//=====================================================================
// TriggerLight.
// A lightsource which can be triggered on or off.
//=====================================================================
// Source:
// http://udn.epicgames.com/Two/UnrealScriptReference.html#Example%20program%20structure
class TriggerLight extends Light;
 
//---------------------------------------------------------------------
// Variables.
 
var() float ChangeTime; // Time light takes to change from on to off.
var() bool bInitiallyOn; // Whether it's initially on.
var() bool bDelayFullOn; // Delay then go full-on.
 
var ELightType InitialType; // Initial type of light.
var float InitialBrightness; // Initial brightness.
var float Alpha, Direction;
var actor Trigger;
 
//---------------------------------------------------------------------
// Engine functions.
 
// Called at start of gameplay.
function BeginPlay()
{
   // Remember initial light type and set new one.
   Disable( 'Tick' );
   InitialType = LightType;
   InitialBrightness = LightBrightness;
   if( bInitiallyOn )
   {
      Alpha = 1.0;
      Direction = 1.0;
   }
   else
   {
      LightType = LT_None;
      Alpha = 0.0;
      Direction = -1.0;
   }
}
 
// Called whenever time passes.
function Tick( float DeltaTime )
{
   LightType = InitialType;
   Alpha += Direction * DeltaTime / ChangeTime;
   if( Alpha > 1.0 )
   {
      Alpha = 1.0;
      Disable( 'Tick' );
      if( Trigger != None )
         Trigger.ResetTrigger();
   }
   else if( Alpha < 0.0 )
   {
      Alpha = 0.0;
      Disable( 'Tick' );
      LightType = LT_None;
      if( Trigger != None )
         Trigger.ResetTrigger();
   }
   if( !bDelayFullOn )
      LightBrightness = Alpha * InitialBrightness;
   else if( (Direction>0 &amp;amp;amp;&amp;amp;amp; Alpha!=1) || Alpha==0 )
      LightBrightness = 0;
   else
      LightBrightness = InitialBrightness;
}
 
//---------------------------------------------------------------------
// Public states.
 
// Trigger turns the light on.
state() TriggerTurnsOn
{
   function Trigger( actor Other, pawn EventInstigator )
   {
      Trigger = None;
      Direction = 1.0;
      Enable( 'Tick' );
   }
}
 
// Trigger turns the light off.
state() TriggerTurnsOff

{
   function Trigger( actor Other, pawn EventInstigator )
   {
      Trigger = None;
      Direction = -1.0;
      Enable( 'Tick' );
   }
}
 
// Trigger toggles the light.
state() TriggerToggle
{
   function Trigger( actor Other, pawn EventInstigator )
   {
      log("Toggle");
      Trigger = Other;
      Direction *= -1;
      Enable( 'Tick' );
   }
}
 
// Trigger controls the light.
state() TriggerControl
{
   function Trigger( actor Other, pawn EventInstigator )
   {
      Trigger = Other;
      if( bInitiallyOn ) Direction = -1.0;
      else Direction = 1.0;
      Enable( 'Tick' );
   }
   function UnTrigger( actor Other, pawn EventInstigator )
   {
      Trigger = Other;
      if( bInitiallyOn ) Direction = 1.0;
      else Direction = -1.0;
      Enable( 'Tick' );
   }
}
