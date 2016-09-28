package montecarlo.common.reflect

import scala.reflect.ClassTag
import scala.reflect.runtime._
import scala.reflect.runtime.universe._
/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Reflect utils
  */
object ReflectUtil {
  def newInstance[C](tt: TypeTag[C], construct: Int, params: Option[Seq[Any]] = None): C = {
    params match {
      case Some(s) => currentMirror.reflectClass(tt.tpe.typeSymbol.asClass)
        .reflectConstructor(tt.tpe.members.filter(m =>
          m.isMethod && m.asMethod.isConstructor
        ).iterator.toSeq(construct).asMethod
        )(params.get: _*).asInstanceOf[C]
      case None => currentMirror.reflectClass(tt.tpe.typeSymbol.asClass)
        .reflectConstructor(tt.tpe.members.filter(m =>
          m.isMethod && m.asMethod.isConstructor
        ).iterator.toSeq(construct).asMethod
        )().asInstanceOf[C]
    }
  }

  def typeTagToClassTag[C](tt: TypeTag[C]): ClassTag[C] = {
    ClassTag[C]( tt.mirror.runtimeClass( tt.tpe ) )
  }
}
