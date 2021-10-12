package com.alabs.multitypeadapter.multiTypeAdapter


internal class DelegateNotFoundException(clazz: Class<*>) : RuntimeException(
  "Have you registered the ${clazz.name} type and its delegate or binder?"
)
