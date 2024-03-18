package middlewares

import "github.com/gin-gonic/gin"

func Cors() gin.HandlerFunc {
	return func(c *gin.Context) {
		// origin := c.Request.Header.Get("Origin")
		// allowed := os.Getenv("ALLOWED_ORIGIN")

		// var pass string
		// ends_with := strings.HasSuffix(origin, allowed)
		// if ends_with {
		// 	pass = origin
		// }

		c.Writer.Header().Set("Access-Control-Allow-Origin", "*")
		c.Writer.Header().Set("Access-Control-Allow-Credentials", "true")
		c.Writer.Header().Set("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Origin, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization, accept, origin, Cache-Control, X-Requested-With")
		c.Writer.Header().Set("Access-Control-Allow-Methods", "POST, OPTIONS, GET, DELETE, PATCH")

		if c.Request.Method == "OPTIONS" {
			c.JSON(204, "Headers not allowed")
			c.Abort()
			return
		}

		c.Next()
	}
}
